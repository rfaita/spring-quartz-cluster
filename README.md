# Quartz com Spring Boot Clustered

## Iniciar aplicação

Inicie executando a construção da aplicação:

```shell script
mvn clean install
```

Inicie a aplicação utilizando o docker-compose:
```shell script
docker-compose up --build
```

Aguarde alguns segundos e você irá verificar que a aplicação iniciou, e um dos containers
assumiu a execução do job:

```shell script
qtest2_1  | 2020-09-18 16:34:24.021  INFO 8 --- [eduler_Worker-3] com.example.quartz.service.TestService   : Running job on supervisor, job id ATestJob
qtest2_1  | 2020-09-18 16:34:24.021  INFO 8 --- [eduler_Worker-3] com.example.quartz.service.TestService   : Completed job on supervisor, job id ATestJob
qtest2_1  | 2020-09-18 16:34:26.026  INFO 8 --- [eduler_Worker-4] com.example.quartz.job.ATestJob          : ATestJob Running
qtest2_1  | 2020-09-18 16:34:26.026  INFO 8 --- [eduler_Worker-4] com.example.quartz.service.TestService   : Running job on supervisor, job id ATestJob
qtest2_1  | 2020-09-18 16:34:26.026  INFO 8 --- [eduler_Worker-4] com.example.quartz.service.TestService   : Completed job on supervisor, job id ATestJob
qtest2_1  | 2020-09-18 16:34:28.044  INFO 8 --- [eduler_Worker-5] com.example.quartz.job.ATestJob          : ATestJob Running
```

No caso de exemplo, podemos verificar que o **qtest2_1** assumiu a execução do job.

Dessa forma vamos parar este processo, utilize o seguinte script:
```shell script
docker rm -f quartz_qtest2_1
```

Dentro de alguns segundos a aplicação **qtest1_1** irá assumir a execução do job:
```shell script
qtest1_1  | 2020-09-18 16:36:42.046  INFO 7 --- [duler_Worker-10] com.example.quartz.service.TestService   : Running job on supervisor, job id ATestJob
qtest1_1  | 2020-09-18 16:36:42.046  INFO 7 --- [duler_Worker-10] com.example.quartz.service.TestService   : Completed job on supervisor, job id ATestJob
qtest1_1  | 2020-09-18 16:36:44.032  INFO 7 --- [eduler_Worker-1] com.example.quartz.job.ATestJob          : ATestJob Running
qtest1_1  | 2020-09-18 16:36:44.033  INFO 7 --- [eduler_Worker-1] com.example.quartz.service.TestService   : Running job on supervisor, job id ATestJob
qtest1_1  | 2020-09-18 16:36:44.033  INFO 7 --- [eduler_Worker-1] com.example.quartz.service.TestService   : Completed job on supervisor, job id ATestJob
```

## Finalizar a execução

Para finalizar a execução da aplicação utilize o Ctrl+C, e para realizar a limpeza dos containers execute:
```shell script
docker-compose rm
```