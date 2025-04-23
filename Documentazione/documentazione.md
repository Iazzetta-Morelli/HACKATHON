# Documentazione del Sistema Hackathon

## Introduzione
L’obiettivo di questo documento è quello di analizzare e modellare un sistema di gestione per eventi di tipo Hackathon, seguendo una traccia fornita come specifica informale. Il sistema deve supportare:
- l’organizzazione di un torneo
- la gestione di utenti (organizzatori, partecipanti, giudici)
- la registrazione
- la creazione dei team
- il caricamento dei progressi
- la valutazione finale

Un hackathon è un evento della durata tipica di due giorni, organizzato da un utente registrato sulla piattaforma: un **organizzatore**. Egli invita dei giudici, stabilisce regole di partecipazione, apre le iscrizioni e definisce:
- la dimensione massima del team
- il numero massimo di partecipanti

I partecipanti possono registrarsi ed eventualmente formare team. Durante l’evento, i giudici:
- pubblicano il problema da affrontare
- valutano i team sulla base degli aggiornamenti caricati
- assegnano punteggi

Al termine dell’evento viene generata una classifica.

---

## User
L’entità `User` identifica un utente generico che verrà specializzato in:
- `Participant`
- `Organizer`
- `Judge`

Queste entità erediteranno metodi e attributi della classe base.

### Attributi
- `username`: identificativo univoco dell’utente
- `email`: utilizzata per il recupero dell’account e per ricevere notifiche importanti
- `password`: accesso sicuro alla piattaforma

### Metodi principali
- `getEmail()`
- `getUsername()`

---

## Participant
Specializzazione di `User`, rappresenta un partecipante che fa parte di un team.

### Attributi
- `team`: riferimento al team di appartenenza
- `isTeamLeader`: true se il partecipante ha creato il team

### Metodi
- `createTeam()`: crea un nuovo team
- `joinTeam()`: entra a far parte di un team esistente tramite nome e codice team

---

## Organizer
Specializzazione di `User`, rappresenta l’organizzatore della competizione.

### Metodi
- `createHackathon()`
- `setStatus()`
- `setTitle()`
- `setLocation()`
- `setStartDate()`
- `setEndDate()`
- `setOrganizer()`
- `setMaxParticipants()`
- `setMaxTeamSize()`
- `setRegistrationDeadline()`
- `inviteJudges()`

---

## Judge
Specializzazione di `User`, rappresenta un giudice incaricato di:
- creare il problema
- commentare gli aggiornamenti
- assegnare un voto finale

### Metodi
- `publishProblem()`: pubblica la traccia del problema
- `addFeedback()`: commenta gli aggiornamenti dei team
- `rateTeam()`: assegna un voto finale
- `publishRanking()`: pubblica la classifica basata sui voti finali

---

## SystemManager
Gestisce l’accesso e la registrazione degli utenti.

### Metodi
- `registerUser()`: registra un nuovo utente (verifica unicità di username ed email)
- `login()`: verifica email e password
- `logout()`: disconnette l’utente

---

## Team
Ogni evento comprende diversi team.

### Attributi
- `teamName`: nome del team
- `teamCode`: codice univoco generato alla creazione
- `teamMembers`: lista dei partecipanti
- `hackathon`: hackathon di riferimento
- `average`: media dei punteggi assegnati dai giudici

### Metodi
- `uploadDocument()`: caricato dal team leader per aggiornare il progetto

---

## Document
Contiene aggiornamenti del progetto e viene commentato dai giudici.

### Attributi
- `title`: titolo del documento
- `team`: team che ha caricato il documento
- `feedback`: giudizio assegnato dal giudice
