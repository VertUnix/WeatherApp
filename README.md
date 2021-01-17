<h1 align="center">
	<img
		width="300"
		alt="logo"
		src="https://cdn.givingcompass.org/wp-content/uploads/2019/12/02081412/Climate-Change-and-the-New-Language-of-Weather-800x450.jpg">
	<p>Weather App</p>
</h1>
<h3 align="center">
	Tema 2 @ Ingineria Programelor
</h3>
<p align="center">
	<strong>
		<a href="https://wiki.mta.ro/c/4/ip/lab/tema2-2020">Wiki Requirements</a>
	</strong>
</p>
<p align="center">
	<a href="https://github.com/GabrielStoica/WebCrawler/tree/master/src"><img
		alt="Build Status"
		src="https://github.com/thelounge/thelounge/workflows/Build/badge.svg"></a>
	<a href="https://github.com/VertUnix/WeatherApp"><img
		alt="Progress status"
		src="https://img.shields.io/badge/Progress-under%20construction-yellow"></a>
	<a href="https://github.com/VertUnix/WeatherApp"><img
		alt="Progress status"
		src="https://img.shields.io/badge/by-VertUnix-informational"></a>

</p>


## Descriere :page_facing_up:

Proiectul de față este conceput pentru a răspunde cerințelor Temei 2 din cadrul laboratorului de _Software Engineering_.
 
Folosirea design pattern-ului Model View Controller asigură proprietatea _loosely coupled_ , logica internă a fiecărui element fiind independentă de a celorlalte două.

![WeatherApp](/uml_and_tests/WeatherApp?raw=true)


## Dependințe :wrench:

[JSON In Java][https://mvnrepository.com/artifact/org.json/json]
[JUnit][https://junit.org/junit5/]
[JavaFX][https://openjfx.io/]

## Utilizare :satellite:

Programul încarcă o listă de orașe cu ID-urile specifice API-ului OpenWeather:

```ID		nm		lat		lon		countryCode
819827	        Razvilka	55.591667       37.740833	RU
524901	        Moscow	        55.752220       37.615555	RU
2973393	        Tarascon	43.805828       4.660280	FR
2986678	        Ploufragan	48.491409       -2.794580	FR
```

Utilizatorul selectează codul unei țări, un oraș din lisă și afișează informațiile meteo prin apăsarea butonului.


### Alte tehnologii/ resurse :books:

- IntelliJ
- Maven
- OpenWeatherMap
- PlantUML
- Draw.io
 
### Autor
VertUnix

### Licență
[GPL 3.0](https://www.gnu.org/licenses/gpl-3.0.html)
