# DOCKER
DC=docker-compose

up:
	@echo "Starting docker containers..."
	@$(DC) up --remove-orphans -d

up-main:
	@echo "Starting main PostgreSQL..."
	@$(DC) up -d postgres-main

up-test:
	@echo "Starting test PostgreSQL..."
	@$(DC) up -d postgres-test

down:
	@echo "Stopping all containers..."
	@$(DC) down --remove-orphans

down-main:
	@echo "Stopping main PostgreSQL..."
	@$(DC) stop postgres-main

down-test:
	@echo "Stopping test PostgreSQL..."
	@$(DC) stop postgres-test

logs-main:
	@$(DC) logs -f postgres-main

logs-test:
	@$(DC) logs -f postgres-test

ps:
	@$(DC) ps

docker-clean:
	@echo "Removing all containers and volumes..."
	@$(DC) down -v
	@sudo rm -rf ${HOME}/.docker-volumes/orm-d

psql-main:
	@docker exec -it orm-d-postgres-main psql -U orm_d_owner -d orm_d

psql-test:
	@docker exec -it orm-d-postgres-test psql -U orm_d_owner -d orm_d
