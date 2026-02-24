package com.example.demo; 
// package = "Namensraum" der Klasse.
// Damit ordnest du die Datei in dein Projekt ein.
// Wichtig in Spring Boot: Spring startet in deinem Haupt-Package (z. B. com.example.demo)
// und sucht dort automatisch nach Controllern, Services usw.

import org.springframework.web.bind.annotation.RestController;
// import = macht die Annotation RestController in dieser Datei nutzbar.
// Ohne import müsstest du den kompletten langen Namen ausschreiben.

import org.springframework.web.bind.annotation.GetMapping;
// import für die Annotation, mit der du eine URL auf eine Methode legst.

@RestController
// Annotation = eine Markierung mit @, also Metadaten für Spring.
// Java selbst führt dadurch nicht "magisch" Code aus.
// Aber Spring liest diese Markierung beim Start und versteht:
// "Diese Klasse verarbeitet HTTP-Anfragen."
//
// @RestController ist praktisch eine REST-Variante von Controller.
// Bedeutet: Rückgabewerte (z. B. String, Objekte) werden direkt als HTTP-Antwort gesendet.
// Hier also direkt Text im Browser.

public class HelloWorldController {
// public = von außen sichtbar (Spring kann die Klasse verwenden).
// class = du definierst eine Klasse.
// HelloWorldController = Name der Klasse.
// "Controller" ist nur eine Benennungskonvention, damit man sofort erkennt:
// Diese Klasse kümmert sich um Web-Endpunkte.

    @GetMapping(path = "/hello")
    // Annotation an der Methode.
    // Bedeutet:
    // - HTTP-Methode: GET (also Browser-Aufruf / URL aufrufen)
    // - Pfad: /hello
    //
    // Ergebnis:
    // Wenn du im Browser http://localhost:8080/hello aufrufst,
    // ruft Spring genau diese Methode auf.
    //
    // "/": Startseite
    // "/hello": dein Endpunkt
    // Wenn du nur localhost:8080 aufrufst, bekommst du 404,
    // weil dafür hier kein Mapping existiert.

    public String helloWorld() {
    // public = Spring darf die Methode aufrufen.
    // String = Rückgabetyp der Methode (sie liefert Text zurück).
    // helloWorld = frei gewählter Methodenname.
    //
    // Wichtiger Zusammenhang:
    // Weil oben @RestController steht, interpretiert Spring diesen String
    // nicht als Dateinamen/Template, sondern als direkten Antwortinhalt.

        //return "Hello World";
         return """
            <!DOCTYPE html>
            <html lang="de">
            <head>
                <meta charset="UTF-8">
                <title>Hello</title>
            </head>
            <body>
                <h1>Hello World</h1>
                <p>Das ist HTML ausasdasd einem Spring Boot Controller.</p>
            </body>
            </html>
            """;
        // return = Rückgabewert der Methode.
        // Dieser Text wird als HTTP-Response an den Browser gesendet.
        //
        // Browser zeigt dann einfach an:
        // Hello World
    }
}