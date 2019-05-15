# chat-interface
Das Interface-Projekt für das Chat-Server-Client-project für die Schule

Dieses Projekt enthält die Klassen, welche zur Kommunikation zwischen Server und Client genutzt werden.
Die Kommunikation läuft über Sockets, diese können ausschließlich Byte-Arrays übertragen.

Um bei einer Übertragung den Anfang einer Nachricht zu kennzeichnen, wird in das erste Byte der Typ der Nachricht geschrieben.
Dieser Typ steht als static final Variable mit dem Name "TYPE_ID" in der dazugehörigen Klasse.
Darauf folgt das zweite bis fünfte Byte (4 Bytes = 1 int) in dem die Länge der Nachricht steht. Als drittes und letztes folgt die eigentlich zu übertragende Nachricht.

**Beispiel:**

Typ: `Message`  
Länge: `13`  
Message: `{"foo":"bar"}`  

Raw:

````txt
 01  00 00 00 0d  7b 22 66 6f 6f 22 3a 22 62 61 72 22 7d
|-|  |---------|  |------------------------------------|
Typ     Länge                   Nachricht
````

Ein Code-Beispiel für das parsen von einem Java-Objekt in ein byte[] kann in den Tests gefunden werden. 