# Creazione di una chat P2P
## Scopo
Il progetto richiede che la chat avvenga senza l'utilizzo di un server e che un altro programma possa funzionare senza il bisogno di modifiche del codice.
## Struttura
Nell'interfaccia utente troviamo due campi per l'inserimento del nome dell'utente e dell'indirizzo Ip a cui ci si vuole connettere, una label per visualizzare 
i messaggi inviati e ricevuti ed infine una text area per scrivere il messaggio da inviare.
## Come si utilizza
Per prima cosa inserire il nome di chi utilizza la chat e poi l'indirizzo del destinatario una volta fatto il bottone "connetti" si attiva e permette di inviare al ricevitore 
il messaggio che contiene il nome utente. Una volta stabilita la connessione sarà possibile inviare messaggi attraverso la text area scrivendo il proprio messaggio e premendo 
invio, nella label che mostra la chat vengono mostrati tutti i messaggi sia inviati che ricevuti. Per chiudere infine la connessione bisogna premere il bottone disconnetti che 
chiuderà la connessione con l'utente.

### Linguaggio utilizzato
```java
JOptionPane.showConfirmDialog(null, "Accettare la connessione?", "?", choose);
System.out.println("e' linguaggio java");
```
