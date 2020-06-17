<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
  <link rel="stylesheet" href="https://stackedit.io/style.css" />
</head>

<body class="stackedit">
  <div class="stackedit__html"><h1 id="progetto-gf---computer">Progetto GF   💻</h1>
<p>Il programma presente nella repository è una REST API che permette di filtrare e ottenere dati relativi ai tweet della timeline.</p>
<h2 id="i-dati-floppy_disk">I dati 💾</h2>
<p>I dati forniti dal programma risultano in formato JSON composto da un array di tweet che formano la timeline.<br>
Il formato del singolo tweet è il seguente:</p>
<pre><code>[
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
</code></pre>
<p>dove:</p>
<ul>
<li><em><strong>created_at</strong></em> rappresenta la data di creazione del tweet;</li>
<li><em><strong>id</strong></em> rappresenta l’id del tweet;</li>
<li><em><strong>geo</strong></em> rappresenta il luogo dov’è geolocalizzato il tweet;</li>
<li><em><strong>user</strong></em> rappresenta l’utente ed è a sua volta composto da:</li>
<li><em><strong>name_user</strong></em> nome dell’utente;</li>
<li><em><strong>screen_name</strong></em> nome a video dell’utente;</li>
<li><em><strong>location_user</strong></em> location relativa all’utente;</li>
<li><em><strong>id user</strong></em> numero identificativo dell’utente;</li>
</ul>
<h2 id="interfaccia---speech_balloon">Interfaccia   💬</h2>
<p>Per rendere possibile anche a chi non conosce un linguaggio di programmazione di consultare il nostro servizio abbiamo ideato una semplice GUI (elaborata in linguaggio java). E resa consultabile come JAR eseguibile.<br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/GT.JPG" alt="GUI del JAR Runnable"></p>
<h2 id="possibili-rotte-dellapplicazione--bar_chart">Possibili rotte dell’applicazione  📊</h2>

<table>
<thead>
<tr>
<th><em><strong>TIPO</strong></em></th>
<th><em><strong>CHIAMATA</strong></em></th>
<th><em><strong>RISPOSTA</strong></em></th>
</tr>
</thead>
<tbody>
<tr>
<td>GET</td>
<td>/data</td>
<td>Restituisce tutta la timeline</td>
</tr>
<tr>
<td>GET</td>
<td>/metadata</td>
<td>Restituisce gli alias utilizzati</td>
</tr>
<tr>
<td>GET</td>
<td>/stats</td>
<td>Restituisce il numero dei tweet con location</td>
</tr>
<tr>
<td>POST</td>
<td>/data</td>
<td>Restituisce i tweet che rispettano i filtri</td>
</tr>
<tr>
<td>POST</td>
<td>/stats</td>
<td>Restituisce la frequenza di location per utente</td>
</tr>
</tbody>
</table><h5 id="esempi-di-possibili-chiamate">Esempi di possibili chiamate</h5>
<ol>
<li><em><strong>GET</strong></em> localhost:8080/data</li>
<li><em><strong>GET</strong></em>  localhost:8080/metadata</li>
<li><em><strong>GET</strong></em>  localhost:8080/stat</li>
<li><em><strong>POST</strong></em>  localhost:8080/data</li>
<li><em><strong>POST</strong></em>  localhost:8080/stat</li>
</ol>
<p><em>N.B.: Per le 2 <em><strong>POST</strong></em> il filtro va scritto nel body.</em></p>
<h2 id="filtri----mag">Filtri    🔍</h2>

<table>
<thead>
<tr>
<th><em><strong>OPERATORE</strong></em></th>
<th><em><strong>DESCRIZIONE</strong></em></th>
</tr>
</thead>
<tbody>
<tr>
<td>In</td>
<td>Mostra i tweet con il valore specificato</td>
</tr>
<tr>
<td>Nin</td>
<td>Mostra i tweet senza il valore specificato</td>
</tr>
</tbody>
</table><p>E’ possibile combinare più filtri utilizzando la logica AND/OR.<br>
<em>N.B.: è possibile inserire un filtro per ogni campo contemporaneamente, concatenati nel modo desiderato(and/or).</em></p>
<h5 id="esempio-di-filtro-da-scrivere-nel-body-della-chiamata-effettuata-con-postman">Esempio di filtro da scrivere nel body della chiamata effettuata con <em>Postman</em></h5>
<p>{ “Location_user”:{“In”:[“Milano”]}, “Name”:{“Type”:“and”,“In”:[“Corriere della Sera”]} }</p>
<h2 id="uml---globe_with_meridians">UML   🌐</h2>
<h3 id="diagramma-delle-classi">Diagramma delle classi</h3>
<p><em><strong>gf2.progettoOOP.SpringBootApp</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/SpringBootApp.JPG" alt="SpringBootApp"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Controller</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Controller.JPG" alt="Controller"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Exception</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Exception.JPG" alt="Exception"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Filter</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Filter.JPG" alt="Filter"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.GUI</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/GUI.JPG" alt="GUI"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Model</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Model.JPG" alt="Model"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Service</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Service.JPG" alt="Service"><br>
<em><strong>gf2.progettoOOP.SpringBootApp.Utils</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/Utils.JPG" alt="Utils"></p>
<h3 id="diagramma-dei-casi-duso">Diagramma dei casi d’uso</h3>
<p><em><strong>get/data</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_data.jpg" alt="get/data"><br>
<em><strong>get/metadata</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_metadata.jpg" alt="get/metadata"><br>
<em><strong>get/stats</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/get_stat.jpg" alt="get/stats"><br>
<em><strong>post/data</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/post_data.jpg" alt="post/data"><br>
<em><strong>post/stats</strong></em><br>
<img src="https://github.com/MargheritaGaleazzi/ProgettoEsame/blob/master/foto/post_stat.jpg" alt="post/stats"></p>
<h2 id="autori--busts_in_silhouette">Autori  👥</h2>
<ul>
<li>Margherita Galeazzi</li>
<li>Alessandro Falcioni</li>
</ul>
</div>
</body>

</html>
