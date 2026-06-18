# Hangman Game

A desktop Hangman game built with **Java Swing**, featuring a modular GUI architecture, event-driven gameplay, and a dictionary of **1,000+ words**.

---

## Overview

This project is a fully playable Hangman experience with a clean, dark-themed interface. Players guess letters via an on-screen alphabet keyboard, track remaining lives through a visual health bar, and receive win/loss dialogs with the option to replay instantly.

The codebase is organized into focused, single-responsibility classes — demonstrating object-oriented design, GUI composition, and separation of game logic from presentation.

---

## Features

- **Interactive alphabet keyboard** — 26 letter buttons with immediate visual feedback on each guess
- **Dynamic word display** — masked letters reveal in place as correct guesses are made
- **Visual health system** — 7-life tracker with color-coded segments (green → red)
- **Win & loss flows** — victory highlighting, word reveal on defeat, and replay/exit prompts
- **Large word bank** — 1,000+ words loaded from an external text file at runtime
- **Instant replay** — full game state reset without restarting the application

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| GUI Framework | Java Swing (`JFrame`, `JPanel`, `JButton`, `JLabel`) |
| Layout Managers | `GridLayout`, `FlowLayout` |
| I/O | `java.io`, `java.util.Scanner` |
| Event Handling | `ActionListener` |

---

## Architecture

The application follows a **component-based GUI pattern**, where `MainWindow` acts as the root container and delegates responsibility to specialized panels:

```
Run
 └── MainWindow (JFrame)
      ├── HealthPanel      — life counter & visual health bar
      ├── WordPanel        — masked word display & guess logic
      └── ButtonPanel      — alphabet keyboard & game flow control
           └── EndGame     — win/loss handling & state reset
```

| Class | Responsibility |
|-------|----------------|
| `Run` | Application entry point; configures and launches the window |
| `MainWindow` | Composes all GUI panels into a 3-row grid layout |
| `FileLoader` | Loads words from `Words.txt` and selects a random word each round |
| `WordPanel` | Renders the masked word, validates guesses, detects a full solve |
| `HealthPanel` | Tracks remaining lives and updates the health bar UI |
| `ButtonPanel` | Handles letter button clicks and orchestrates game logic |
| `EndGame` | Manages victory/defeat dialogs and resets all components for replay |

---

## Skills Demonstrated

- **Object-Oriented Programming** — inheritance (`FileLoader extends ArrayList`), encapsulation, and clear class boundaries
- **GUI Development** — building responsive desktop UIs with Swing layout managers and custom styling
- **Event-Driven Programming** — `ActionListener` implementation for real-time user input handling
- **File I/O** — reading and parsing external data files at runtime
- **State Management** — coordinating shared state across multiple UI components and resetting cleanly between rounds
- **Game Logic** — guess validation, win/loss detection, and round lifecycle management

---

## Getting Started

### Prerequisites

- [Java JDK 8+](https://www.oracle.com/java/technologies/downloads/) installed
- An IDE such as [Eclipse](https://www.eclipse.org/downloads/) (recommended — project files included) or any Java editor

### Run with Eclipse

1. Clone or download this repository
2. Open Eclipse → **File → Open Projects from File System**
3. Select the project root folder
4. Ensure `Words.txt` is in the project root (same level as `.project`)
5. Run `hangman.Run` as a **Java Application**

### Run from the Command Line

From the project root directory (where `Words.txt` is located):

```bash
javac -d bin src/hangman/*.java
java -cp bin hangman.Run
```

> **Note:** `Words.txt` must be in the working directory when the program runs, since `FileLoader` reads it via a relative path.

---

## Project Structure

```
Hangman Game/
├── README.md
├── Words.txt                  # 1,000+ word dictionary
├── src/
│   └── hangman/
│       ├── Run.java           # Entry point
│       ├── MainWindow.java    # Root window & layout
│       ├── FileLoader.java    # Word file I/O & random selection
│       ├── WordPanel.java     # Word display & guess logic
│       ├── HealthPanel.java   # Lives & health bar
│       ├── ButtonPanel.java   # Alphabet keyboard & events
│       └── EndGame.java       # Win/loss & replay logic
└── bin/                       # Compiled output (gitignored)
```

---

## How to Play

1. A random word is chosen and displayed as underscores
2. Click a letter on the alphabet keyboard to guess
3. Correct guesses reveal the letter in the word
4. Incorrect guesses remove one life from the health bar
5. Win by guessing the full word before running out of lives
6. Choose **Play Again** to start a new round, or exit the game

---

## Author

**Aryan** — built as a portfolio project showcasing Java GUI development and OOP fundamentals.
