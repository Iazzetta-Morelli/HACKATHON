# Introduzione

L’obiettivo di questo documento è quello di analizzare e modellare un sistema di gestione per eventi di tipo Hackathon, seguendo una traccia fornita come specifica informale. Il sistema deve supportare l’organizzazione di un torneo, la gestione di utenti (organizzatori, partecipanti, giudici), la registrazione, la creazione dei team, il caricamento dei progressi e la valutazione finale.

Un hackathon è un evento della durata tipica di due giorni, organizzato da un utente registrato sulla piattaforma: un organizzatore. Egli invita dei giudici, stabilisce regole di partecipazione, apre le iscrizioni e definisce la dimensione massima del team e il numero massimo di partecipanti. I partecipanti possono registrarsi ed eventualmente formare team. Durante l’evento, i giudici pubblicano il problema da affrontare e valutano i team sulla base degli aggiornamenti caricati, assegnando dei punteggi. Al termine dell’evento, viene generata una classifica.

## User

L’entità `User` è un’entità che va a identificare un utente generico che verrà specializzato in (`Participant`, `Organizer`, `Judge`) che erediteranno metodi e attributi. Ogni User avrà:

- **Username**: serve per identificare in maniera univoca un utente.
- **Email**: serve per gestire il recupero della password o dell’account, inoltre è utile per ricevere le notifiche riguardo le informazioni dell’evento come annunci importanti dell’organizzazione e reminder delle deadline.
- **Password**: permette l’accesso sicuro all’account specifico.

Questi elementi sono fondamentali per l’accesso alla piattaforma. I metodi `getEmail`, `getUsername`, sono metodi di interfaccia.

Le specializzazioni (`Participant`, `Organizer`, `Judge`) erediteranno metodi e attributi di `User`.

## Participant

L’entità `Participant` è una specializzazione di `User`, che va a identificare un tipo di utente specifico. Il partecipante farà parte di un team. Avrà quindi i seguenti attributi:

- **Team**: che richiama il tipo di team al quale un partecipante fa parte.
- **isTeamLeader**: un partecipante è un team leader se ha creato un team. Se il partecipante in questione è un team leader gli verrà assegnato un codice team che potrà dare ad altri partecipanti che dovranno entrare a far parte di un team.

Inoltre saranno coloro che creeranno o si uniranno a dei team. I loro metodi sono i seguenti:

- `createTeam`: per creare un team (qualora l’utente non faccia parte di nessun team).
- `joinTeam`: entrare a far parte di un team selezionando il nome del team e inserendo il codice team (qualora l’utente non faccia parte di nessun team).

## Organizer

L’entità `Organizer`, anch’essa specializzazione di `User`, va a identificare l’organizzatore. Sarà colui incaricato della gestione della competizione. Avrà il compito di creare la competizione, trovare la località, decidere tecnicismi relativi alla composizione dell’evento come: il numero massimo di utenti che l’evento può ospitare, il numero massimo di partecipanti per team, il termine di inizio e fine dell’evento e della registrazione alla piattaforma.

`Organizer` presenta dunque i seguenti metodi:

- `createHackathon`: darà la possibilità agli organizzatori di creare un Hackathon.
- `setStatus`: permetterà di stabilire se esso è operativo o meno.
- `setTitle`: va a definirne il nome.
- `setLocation`: permette agli organizzatori di decidere il luogo di riferimento.
- `setStartDate`: definisce il giorno di inizio dell’Hackathon.
- `setEndDate`: definisce il giorno di fine dell’Hackathon.
- `setOrganizer`: permette di modificare l’organizzatore, nel momento in cui l’organizzatore precedente venga sostituito.
- `setMaxParticipants`: permette agli organizzatori di stabilire il numero massimo di partecipanti.
- `setMaxTeamSize`: definisce il numero massimo di partecipanti che possono comporre un team.
- `setRegistrationDeadline`: dichiara il termine di scadenza per registrarsi alla competizione.
- `inviteJudges`: permette agli organizzatori di invitare i giudici.

## Judge

L’entità `Judge` è l’ultima specializzazione di `User`. Ogni giudice è incaricato di creare il problema pubblicando la traccia, di leggere il documento relativo al progetto del team ogni volta che viene aggiornato, aggiungendo un commento. Alla fine del progetto, deve votare il lavoro complessivo del team.

Il `Judge` avrà dunque i seguenti metodi:

- `publishProblem`: permette al giudice di inserire la traccia del problema da risolvere.
- `addFeedback`: dà al giudice la possibilità di aggiungere un commento al lavoro del team ogni volta che il documento viene aggiornato.
- `rateTeam`: assegna al team un voto complessivo per il lavoro svolto; al termine verrà fatta una media dei voti complessivi.
- `publishRanking`: i giudici a fine gara devono pubblicare una classifica che sarà determinata dai voti che i team hanno raggiunto.

## SystemManager

A gestire il corretto funzionamento dell’accesso è il `SystemManager`, che dato l’attributo utente, permette di effettuare la registrazione, il login e il logout. I metodi sono i seguenti:

- `registerUser`: qualora l’utente non fosse registrato, la registrazione raccoglierà dati essenziali, come il nome utente, l’email e la password. Il nome utente e l’email (se non sono già presenti) verranno salvati in una lista, per garantire unicità. La password a sua volta deve essere salvata in una lista per garantire l’accesso sicuro ad un utente specifico.
- `login`: verifica che la mail faccia parte della lista e che la password corrispondente sia corretta.
- `logout`: permette all’utente di scollegarsi dalla piattaforma.

## Team

L’evento si compone di diversi team che avranno un numero preciso di membri e un nome univoco. I team sono delle composizioni di utenti. Gli attributi sono:

- **teamName**: indica il nome del team di cui fanno parte.
- **teamCode**: codice che viene generato alla creazione del team e assegnato al team leader, permettendo agli utenti di unirsi ad un team specifico.
- **teamMembers**: indica una lista di utenti appartenenti a ciascun team.
- **hackathon**: indica l’hackathon di riferimento.
- **average**: indica la somma di tutti i voti assegnati dal giudice.

Gli utenti hanno l’obbligo di caricare il documento relativo al progetto periodicamente:

- `uploadDocument`: questo viene caricato dal team leader.

## Document

Il documento contiene gli aggiornamenti periodici del progetto e verrà commentato dai giudici. Il documento presenta i seguenti attributi:

- **title**: rappresenta il titolo del documento.
- **team**: indica il team che ha caricato il documento.
- **feedback**: indica il giudizio assegnato dal giudice.
