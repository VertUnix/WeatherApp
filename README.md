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
		•
		<a href="https://docs.google.com/document/d/11szgR8-hIbZpbWlpFhaholPJg9oxO2bLi_jbBeudsNo/edit">---</a>
		•
		<a href="https://google.com">---</a>
	</strong>
</p>
<p align="center">
	<a href="https://github.com/GabrielStoica/WebCrawler/tree/master/src"><img
		alt="Build Status"
		src="https://github.com/thelounge/thelounge/workflows/Build/badge.svg"></a>
	<a href="https://github.com/VertUnix/WeatherApp"><img
		alt="Progress status"
		src="https://img.shields.io/badge/Progress-under%20construction-yellow"></a>
</p>


## Descriere :page_facing_up:

Proiectul de față este conceput pentru a răspunde cerințelor Temei 2 din cadrul laboratorului de _Software Engineering_.
 
Folosirea design pattern-ului Model View Controller asigură proprietatea _loosely coupled_ , logica internă a fiecărui element fiind independentă a celorlalte două.


## Instalare :wrench:

**Linux** Folosind managerul de pachete apt-get \
**Windows** Folosind installer-ul 

```bash
sudo apt-get install web-crawler
```

## Utilizare :satellite:

Fișier de configurare (*config.conf*):

```text
n_threads=50
delay=100ms
root_dir=D:/Download
log_level=3
depth_level=3
max_size=500kB
files_type=all/png/jpg/js/php
```

Exemplu metodă Java:

```java

public Crawl(String sitesFilename, Configuration config) throws FileNotFoundException {
        this._sitesFilename = sitesFilename;
        this._config = config;
    }
```

Exemplu cod Powershell:
```powershell
Copy-Item "C:\Logfiles" -Destination "C:\Drawings\Logs" -Recurse

crawler crawl config.conf sites.txt

crawler sitemap D:/Download/numesite1.ro
```

## Resurse :books:

- [Lots of readme.md examples][1]
- [Yet another example][2]
- [Emojis][3]
- ["Shields" badges][4]

[1]: https://github.com/matiassingers/awesome-readme
[2]: https://www.makeareadme.com/
[3]: https://gist.github.com/rxaviers/7360908
[4]: https://shields.io/

## License
[GPL 3.0](https://www.gnu.org/licenses/gpl-3.0.html)
