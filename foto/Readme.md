# Progetto GF   :computer:

Il programma presente nella repository è una REST API che permette di filtrare e ottenere dati relativi ai tweet della timeline.
## I dati :floppy_disk:
I dati forniti dal programma risultano in formato JSON composto da un array di tweet che formano la timeline.
Il formato del singolo tweet è il seguente:

    [
    {
    "created_at": "Wed May 27 14:01:29 +0000 2020",
    "id": 1265644294913822722,
    "geo": null,
    "user":{
    "name_user":"Security Testing",
    "screen_name":"Security Testing",
    "location_user":"India",
    "id_user":"1250489655864647",
    }
    }
    ...
    ]
dove:

 - ***created_at*** rappresenta la data di creazione del tweet;
 - ***id*** rappresenta l'id del tweet;
 - ***geo*** rappresenta il luogo dov'è geolocalizzato il tweet;
 - ***user*** rappresenta l'utente ed è a sua volta composto da:
 - ***name_user*** nome dell'utente;
 - ***screen_name*** nome a video dell'utente;
 - ***location_user*** location relativa all'utente;
 - ***id user*** numero identificativo dell'utente;
 
## Interfaccia   :speech_balloon:
Per rendere possibile anche a chi non conosce un linguaggio di programmazione di consultare il nostro servizio abbiamo ideato una semplice GUI (elaborata in linguaggio java). E resa consultabile come JAR eseguibile.
![GUI del JAR Runnable](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/GUI.JPG)

## Possibili rotte dell'applicazione  :bar_chart: 
  
***TIPO***|***CHIAMATA***|***RISPOSTA***|
------------|--------------------|-------|
GET|/data|Restituisce tutta la timeline|
GET|/metadata|Restituisce gli alias utilizzati|
GET|/stats|Restituisce il numero dei tweet con location|
POST|/data|Restituisce i tweet che rispettano i filtri|
POST|/stats|Restituisce la frequenza di location per utente|
##### Esempi di possibili chiamate

 1. ***GET*** localhost:8080/data
 2. ***GET***  localhost:8080/metadata
 3. ***GET***  localhost:8080/stat
 4. ***POST***  localhost:8080/data
 5. ***POST***  localhost:8080/stat
 
 *N.B.: Per le 2 ***POST*** il filtro va scritto nel body.*

## Filtri    :mag:
***OPERATORE***|***DESCRIZIONE***|
----------------|----------------|
In|Mostra i tweet con il valore specificato|
Nin|Mostra i tweet senza il valore specificato|

E' possibile combinare più filtri utilizzando la logica AND/OR.
*N.B.: è possibile inserire un filtro per ogni campo contemporaneamente, concatenati nel modo desiderato(and/or).*
##### Esempio di filtro da scrivere nel body della chiamata effettuata con _Postman_
{ "Location_user":{"In":["Milano"]}, "Name":{"Type":"and","In":["Corriere della Sera"]} }
## UML   :globe_with_meridians:
### Diagramma delle classi
***gf2.progettoOOP.SpringBootApp***
![SpringBootApp](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/SpringBootApp.JPG)
***gf2.progettoOOP.SpringBootApp.Controller***
![Controller](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Controller.JPG)
***gf2.progettoOOP.SpringBootApp.Exception***
![Exception](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Exception.JPG)
***gf2.progettoOOP.SpringBootApp.Filter***
![Filter](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Filter.JPG)
***gf2.progettoOOP.SpringBootApp.GUI***
![GUI](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/GUI.JPG)
***gf2.progettoOOP.SpringBootApp.Model***
![Model](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Model.JPG)
***gf2.progettoOOP.SpringBootApp.Service***
![Service](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Service.JPG)
***gf2.progettoOOP.SpringBootApp.Utils***
![Utils](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Utils.JPG)

### Diagramma dei casi d'uso
***get/data***
![get/data](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_data.jpg)
***get/metadata***
![get/metadata](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_metadata.jpg)
***get/stats***
![get/stats](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_stat.jpg)
***post/data***
![post/data](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/post_data.jpg)
***post/stats***
![post/stats](https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/post_stat.jpg)

## Autori  :busts_in_silhouette:

 - Margherita Galeazzi
 - Alessandro Falcioni

