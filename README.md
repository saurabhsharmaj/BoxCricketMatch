# 🏏 Box Cricket Match Manager

An **Android application** built with **Kotlin + Jetpack Compose**, following **MVVM architecture** and **Repository pattern**, to manage and track **Box Cricket matches** with scoring, player stats, and leaderboards.

---

## ✨ Functional Requirements

### 🏟️ Match Setup
- Create a new match with:
  - Match Name, Date, Place
  - Number of overs (configurable)
  - Rules: max overs per bowler, wide/no-ball extra run value

### 👥 Team & Player Management
- Create teams
- Add players to teams with:
  - Name, Photo, Mobile number, Role (Batsman/Bowler/All-rounder)
- Edit/update player profiles anytime

### 🎮 Match Flow
- Start the match → **Live Score Tracking screen**
- Track and update:
  - Runs, 4s, 6s per player
  - Run-outs, catches, wickets per bowler/fielder
- Auto change **bowler/batsman** after each over (manual override available)
- Mark a player as **out** and record bowler against dismissal
- Allow **mid-match player edits**

### 📊 Scoring & Leaderboard
- Display **overall team score** (runs, wickets, overs)
- Display **individual player stats**
- Generate **leaderboard with MVP points** (performance-based)
- **Role-based access** → associate players can view leaderboard

### 💾 Data Storage & Sync
- Use **MongoDB (Remote DB)** for:
  - Matches, Teams, Players, Scores, Leaderboards
- Provide REST APIs:
  - `POST /match` → Create match
  - `PUT /match/:id` → Update match
  - `DELETE /match/:id` → Delete match
  - `GET /match/:id` → Fetch match details
- **Offline Mode**:
  - Store data locally (Room/SQLite) if no internet
  - Sync with MongoDB when online
  - Remove local copy once synced

### 🎨 UI/UX
- Jetpack Compose UI with **Material3 Design**
- Beautiful icons for **Batsman, Bowler, Fielder, App logo**
- Easy navigation:  
  `Match Setup → Team Creation → Live Match → Leaderboard`

---

## 🛠️ Technical Requirements

- **Android Client**:  
  Kotlin, Jetpack Compose, MVVM, Room DB (offline), Retrofit (API calls)  

- **Backend**:  
  Node.js + Express (or Java Spring Boot) with MongoDB Atlas  

- **Sync Logic**:  
  Background worker (**WorkManager**) for syncing local DB with remote MongoDB  

- **Code Style**:  
  Clean architecture, modular, well-commented, production-ready  

---

## 📂 Expected Output

### 📱 Android Project Structure
ui/ # Jetpack Compose screens
viewmodel/ # MVVM ViewModels
repository/ # Data access layer
model/ # Data classes (Match, Team, Player, Score, Leaderboard)
db/ # Room entities + DAO for offline storage
network/ # Retrofit API interfaces for backend


### 🌐 Backend Project
- Express or Spring Boot app
- MongoDB schema for Match, Team, Player, Score
- REST endpoints for CRUD operations
- Offline sync support API

### 🖼️ Sample UI Screens
- Match creation form  
- Team & Player management  
- Live scoreboard  
- Leaderboard  

---

## 🚀 Roadmap
- [ ] Implement Android client with Jetpack Compose  
- [ ] Build backend APIs with Node.js/Express or Spring Boot  
- [ ] MongoDB schema + Atlas integration  
- [ ] Offline mode with Room + WorkManager sync  
- [ ] Role-based access & Leaderboard MVP system  
- [ ] UI polish with custom icons & Material3  

---
