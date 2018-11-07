# docker-put-net

### Wymagania
W zależności od używanego systemu operacyjnego wymagana jest instalacja:

* **Docker for Windows** - https://docs.docker.com/docker-for-windows/
* **Docker for Mac** - https://docs.docker.com/docker-for-mac/
* **Docker** - (dla użytkowników Linuxa) https://docs.docker.com/install/linux/docker-ce/ubuntu/

Użytkownicy Linuxa muszą dodatkowo zainstalować *docker-compose*: https://docs.docker.com/compose/install/


### Budowanie obrazów

Przed uruchomieniem *docker-compose* należy zbudować obrazy wszystkich aplikacji. 
W tym celu należy wykonać poniższe kroki dla każdej z usług offer-*:

1. Nadanie prawa wykonania skryptu build.sh (dla uzytkowników systemów z rodziny Unix):
```
chmod u+x offer-storage-service/build.sh
```
2. Zbudowanie obrazu aplikacji w wersji 0.1 (można podać dowolny tag wersji):
```
offer-storage-service/build.sh 0.1
```

Użytkownicy Windowsa muszą wykonać ręcznie polecenia zdefiniowane w skryptach *build.sh*:
```
docker build -t allezon/offer-storage-service:build -f Dockerfile.build .

docker container create --name builder allezon/offer-storage-service:build
docker container cp builder:/tmp/target/offerstorage-0.1-SNAPSHOT.jar ./app.jar
docker container rm -f builder

docker build --no-cache -t allezon/offer-storage-service:0.1 .
```

(Uwaga: powyższe polecenia muszą być wykonywane w katalogach offer-* - nie z głównego katalogu projektu)

Powyższe kroki należy wykonać analogicznie dla usług *offer-cache-service* i *offer-search-service*.
Po wykonaniu wymienionych kroków, w celu sprawdzenia zbudowanych obrazów można wykonać polecenie:
```
docker images
```
które powinno wyświetlić listę obrazów:
```
REPOSITORY                                      TAG  
allezon/offer-storage-service                   0.1  
allezon/offer-storage-service                   build
...
```

W celu uruchomienia wszystkich kontenerów zdefiniowanych w pliku *docker-compose.yml* należy wykonać polecenie:
```
docker-compose up
```

W celu ubicia kontenerów należy wykonać polecenie:
```
docker stop kafka zookeeper offer-storage-service offer-storage-db offer-cache-service offer-cache-db offer-search-service offer-search-db
```

W przypadku wystąpienia błędów proszę o założenie issue.