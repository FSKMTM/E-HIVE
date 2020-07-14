# E-HIVE - navodila za namestitev
Delujoča aplikacija se nahaja na http://83.212.82.142:8081/.

## Predpriprava strežnika

V primeru namestitve na drug strežnik je potrebno spremeniti IP naslov v:
- `frontend/src/global.js`: spremeni `restIp`
- `backend/api/src/main/resources/config.yaml`: spremeni `base-url` in `port`
- `pi/data_transfer.py`: spremeni `url`
- `backend/api/src/main/java/si/fs/kmtm/ehive/api/v1/EhiveAplikacija.java` v definiciji `server`, spremenljivka `url`

Na izbranem strežniku nato potrebujete imeti Postgres bazo oz. ustrezno Docker sliko.
V našem primeru uporabljamo Docker.
Prav tako potrebujete skripto `create_db.sql`, ki se nahaja v `backend/entitete/src/main/resources/sql-scripts/create_db.sql`, prestavite jo v direktorij, iz katerega boste poganjali spodnji ukaz.
Nato v konzoli poženete ukaz, pri čemer pri spremenljivki POSTGRESS_PASSWORD izberete poljubno geslo. 
Ustrezno morate geslo nastaviti tudi v `backend/api/src/main/resources/config.yaml` pod `datasources -> password`.

```
docker run -d --name e-hive -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=GESLO -e POSTGRES_DB=pkp -v $PWD:/docker-entrypoint-initdb.d -p 5432:5432 postgres:10.5
```

V direktoriju, iz katerega se bo na koncu poganjalo aplikacijo, je potrebno ustvariti mapo `slike`.

## Frontend
V primeru sprememb v mapi `frontend` je potrebno pognati sledeči ukaz (ukaz se požene v mapi `frontend`):

```
npm run build
```

Ukaz ustvari datoteko `dist`. Vsebino te mape je potrebno kopirati v mapo `backend/api/src/main/resources/webapp`. 

## Backend

Nato se v mapi `backend` požene ukaz:

```
mvn clean package
```

Ta ukaz v mapi `backend/api/target` zgenerira datoteko `api-1.0-SNAPSHOT.jar`. To datoteko je potrebno prestaviti na izbrani strežnik.

## Zagon na strežniku

V primeru, da se do strežnika dostopa s terminalom preko protokola SSH, se nato na strežniku požene:

```
tmux new-session -s e-hive
```
 S tem ukazom odpremo nov terminal, poimenujemo ga `e-hive`. 
 Da se iz terminala odklopimo, pritisnemo `ctrl+b` nato pa še `d`.
 V terminal se ponovno povežemo z ukazom:
 
 ```
 tmux attach-session -t e-hive
 ```
 
 Ko smo torej v novem terminalu, poiščemo datoteko `api-1.0-SNAPSHOT.jar` in jo poženemo z ukazom:
 
 ```
 java -jar api-1.0-SNAPSHOT.jar
 ```
 
 ## Priprava podnice
 
 Preko aplikacije pod zavihkom `Nastavitve` je potrebno ustvariti novo podnico. 
 Po uspešnem dodajanju se nova podnica prikaže v tabeli vseh podnic v istem zavihku. 
 Izpisano vrednost `Id` je potrebno popraviti v `pi/data_transfer.py`, torej ustrezno nastaviti spremenljivko `PODNICA_ID`.
 
 ## Dokumetacija REST virov
 
 Dokumentacija REST virov se nahaja na http://83.212.82.142:8081/api-specs/ui.

