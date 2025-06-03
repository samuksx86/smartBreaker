
# 🔌 SmartBreaker – Weather Status API

Este projeto é uma API REST desenvolvida com **Spring Boot** e **Java 17**, que consome a API pública da **OpenWeather** para verificar as condições climáticas de uma determinada localização (via latitude e longitude). A partir dessas informações, a API classifica a estabilidade da rede elétrica como `estável` ou `instável`, simulando o comportamento do quadro de luz inteligente **SmartBreaker**.

---

## 📦 Funcionalidades

- Consome dados climáticos em tempo real via OpenWeather API
- Classifica a situação da rede elétrica com base na descrição do clima
- Estrutura modular com camadas bem definidas (controller, service, model, config)
- Padrão REST com retorno em JSON
- Suporte a parâmetros dinâmicos de coordenadas (latitude e longitude)

---

## 🧠 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- RestTemplate
- Maven

---

## 📂 Estrutura do projeto

```
src/
├── main
│   ├── java
│   │   └── com.smartBreaker
│   │       ├── SmartBreakerApplication.java
│   │       ├── controller
│   │       │   └── EnergyController.java
│   │       ├── model
│   │       │   └── EnergyStatusResponse.java
│   │       ├── service
│   │       │   └── EnergyService.java
│   │       └── config
│   │           └── RestTemplateConfig.java
│   └── resources
│       └── application.properties
```

---

## 📄 Exemplo de uso da API

### Endpoint:

```
GET /api/energy/status?lat={latitude}&lon={longitude}
```

### Exemplo:

```
GET http://localhost:8080/api/energy/status?lat=-23.55&lon=-46.63
```

### Resposta:

```json
{
  "status": "instável",
  "weatherDescription": "nuvens dispersas",
  "temperature": 22.4
}
```

---

## ⚙️ Configuração

### 1. Clonar o projeto

```bash
git clone https://github.com/seuusuario/smartbreaker-weather-api.git
cd smartbreaker-weather-api
```

### 2. Configurar o arquivo `application.properties`

```properties
openweather.api.key=SUA_CHAVE_AQUI
openweather.api.weather.url=https://api.openweathermap.org/data/2.5/weather
server.port=8080
```

> 🔑 Você pode obter sua API key gratuita em: https://openweathermap.org/api

---

## 🚀 Executar a aplicação

```bash
./mvnw spring-boot:run
```

---

## ✅ Requisitos atendidos

✔ Consumo de API REST externa (OpenWeather)  
✔ Estrutura modular com serviços reutilizáveis  
✔ Separação entre camadas (Controller, Service, Model)  
✔ Uso de padrões REST + JSON

---

## 👨‍💻 Autor

Desenvolvido por Samuel, para fins acadêmicos e demonstrativos do projeto **SmartBreaker**.
