# Java

## To Do
- [x] Create base - API Task (MongoDB)
- [x] Create base - API Post (PostgreSQL)
- [ ] Create flow FK - API Post
- [ ] Create flow auth - API Post
- [ ] Create test - API Task
- [ ] Create test - API Post
- [x] SonarLint - VS Code
- [x] SonarQube - Docker

### Test
- TDD
- BDD
- [Postman - Newman](https://br.sensedia.com/post/rest-api-entenda-o-passo-a-passo-para-realizar-testes)


### SonarQube

```bash
# https://www.devstringx.com/integrate-the-sonarqube-with-spring-boot

# Command Example|:
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=projectKey \
  -Dsonar.projectName='projectName' \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=token
```