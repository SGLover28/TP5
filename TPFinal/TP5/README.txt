
TP partie 1:

Etape 5:

Web: Permet de mettre en place un model view controller, c'est à dire qu'on peut utiliser du code Java pour notre application Web
JPA: Permet de faire le lien entre une base de donnée et notre code Java, ici nous l'utilisons pour avoir une table Address qui suit les valeurs de notre classe address
Hibbernate: Permet l'implementation de JPA
H2: Permet la génération et l'interaction avec la base de donnée
DevTools: Facilite le développement, et nous permet d'ajouter des propriété dans "application.properties"
Thymeleaf: Permet de faire le lien entre les templates en html et le code Java, pour utiliser les données du model dans la page web


Etape 13

1) avec le @GetMapping("/greeting")
2)Avec la partie "return ''greeting'"
3) le @RequestParma(name="nameGET") va cherche la valeur de nameGET indiquée dans l'URL. Donc la partie "nameGET=ENSIM" indique à la methode Get que la valeu de nameGET est ENSIM

Etape 17: Oui, une nouvelle table a été ajoutée: Address.

Etape 18: grâce au @Entity, hibernate reconaît la nouvelle classe et l'ajoute dans la base de donnée

Etape 19: Oui

Etape 23: AutoWired permet d'avoir l'objet addressRepository dans le reste des classes, dont les controllers, developpées dans le projet

Etape 30: J'ai ajouté un lien href vers le site de Bootstrap de type rel="stylesheet" au thymeleaf fragment développé précédemment puisque ce dernier sera persent dans chaque page notre application.

Partie 2

Etape 6:
- Oui
- Selon le site de openweathermap.org: api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}, où {lat}, {lon} et {API key} sont remplancés respectivement par la latitude de l'adresse, sa longitude et notre clef api
- Une methode HTTPS fonctionne
- J'ai contruit une string correspondant à l'URL où les parametres en {} de la reponse précédentes sont remplacés par les valeurs de la classe Coordinates qui correspond aux coordonées de l'adresse et ma clef API enregistrée en dure.
-   La temperature se trouve dans la partie "temps" de l'objet json  "main" inclu dans la réponse
    les prévisions méteo sont dans la partie description de le premier object Json du tableau d'objet Json "weather"


Lien Github:https://github.com/SGLover28/TP5/