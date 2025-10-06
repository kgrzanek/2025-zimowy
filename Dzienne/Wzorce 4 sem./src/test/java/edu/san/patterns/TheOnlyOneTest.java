// © 2025 Konrad Grzanek <kongra@gmail.com>
package edu.san.patterns;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TheOnlyOneTest {

  private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  void setUpStreams() {
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  void testSingletonReturnsSameInstance() {
    // Get the instance twice
    final var instance1 = TheOnlyOne.getInstance();
    final var instance2 = TheOnlyOne.getInstance();

    // Both should be the exact same object
    assertSame("getInstance() should return the same instance", instance1,
        instance2);
  }

  @Test
  void testConstructorCalledOnlyOnce() {
    // Clear any previous output
    outputStream.reset();

    // Call getInstance multiple times
    TheOnlyOne.getInstance();
    TheOnlyOne.getInstance();
    TheOnlyOne.getInstance();

    // Constructor should only be called once
    final var output = outputStream.toString();
    System.out.println("--1" + output);

    final var count = output.split("TheOnlyOne::TheOnlyOne\\(\\)", -1).length
        - 1;

    assertEquals(1, count, "Constructor should be called exactly once");
  }

  @Test
  void testThreadSafety() throws InterruptedException {
    final var threadCount = 100;
    final Set<TheOnlyOne> instances = ConcurrentHashMap.newKeySet();
    final var startLatch = new CountDownLatch(1);
    final var endLatch = new CountDownLatch(threadCount);

    try (final var executor = Executors.newFixedThreadPool(threadCount)) {
      // Create multiple threads that will all try to get the instance
      // simultaneously
      for (var i = 0; i < threadCount; i++) {
        executor.submit(() -> {
          try {
            // Wait for all threads to be ready
            startLatch.await();

            // Get the instance
            final var instance = TheOnlyOne.getInstance();
            instances.add(instance);

          } catch (final InterruptedException _) {
            Thread.currentThread().interrupt();
          } finally {
            endLatch.countDown();
          }
        });
      }

      // Release all threads at once
      startLatch.countDown();

      // Wait for all threads to complete
      final var completed = endLatch.await(5, TimeUnit.SECONDS);
      assertTrue("All threads should complete within timeout", completed);

      executor.shutdown();

    }

    // All threads should have gotten the exact same instance
    assertEquals(1, instances.size(),
        "All threads should receive the same singleton instance");
  }

  @Test
  void testMultipleCallsReturnIdenticalHashCode() {
    final var instance1 = TheOnlyOne.getInstance();
    final var instance2 = TheOnlyOne.getInstance();

    assertEquals(instance1.hashCode(), instance2.hashCode(),
        "Same instance should have same hash code");
  }

  @Test
  void testEqualityOfInstances() {
    final var instance1 = TheOnlyOne.getInstance();
    final var instance2 = TheOnlyOne.getInstance();

    assertEquals(instance1, instance2, "Instances should be equal");
    assertSame("Instances should be identical (same reference)", instance1,
        instance2);
  }
}