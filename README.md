# 🎓 Student Result Management System

[![Java](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![OOP](https://img.shields.io/badge/Concept-OOP-blueviolet)](https://en.wikipedia.org/wiki/Object-oriented_programming)
[![Collections](https://img.shields.io/badge/Java-Collections_Framework-007396)](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
[![Scanner](https://img.shields.io/badge/Input-Scanner-green)](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

A Java console-based application for managing student academic results with a clean OOP design. The system supports adding records, viewing all results, searching by student ID, and automatically saving/loading data from file storage.

---

## 🚀 Overview

The **Student Result Management System** is designed as a beginner-friendly but practical Java project. It demonstrates:

- Class-based design (`Student`, `ResultManager`, `Main`)
- Core Java control flow using a menu loop
- Automatic percentage and grade computation
- Basic persistence using file handling

When the program starts, it loads previous records (if available), then repeatedly shows a menu until the user chooses to exit.

---

## ✨ Features

- 📌 Add a student with ID, name, and 3 marks
- 🧮 Auto-calculate total and percentage
- 🏅 Auto-assign grade (`A`, `B`, `C`, `Fail`)
- 📋 View all stored student results
- 🔍 Search a student by unique ID
- 💾 Save records to a local file after updates
- 🔄 Load saved records on startup

---

## 🧱 Project Structure

```text
Student-Result-Management-System/
├── README.md
├── run.bat
└── src/
    ├── Main.java          # Program entry point and menu loop
    ├── ResultManager.java # Record management + file I/O
    └── Student.java       # Student model and grade logic
```

---

## 🔄 Detailed Application Flow (Mermaid)

```mermaid
flowchart TD
    A([Start Program]) --> B[Create ResultManager]
    B --> C[Load student data from data/students.txt]
    C --> D{Records file exists?}
    D -- No --> E[Continue with empty list]
    D -- Yes --> F[Read each line and rebuild Student objects]
    E --> G[Display main menu]
    F --> G

    G --> H{User choice?}

    H -- "1. Add Student" --> I[Read ID, Name, Marks1, Marks2, Marks3]
    I --> J[Create Student object]
    J --> K[Add to list in ResultManager]
    K --> L[Save full list to file]
    L --> G

    H -- "2. View All Results" --> M{Any students in list?}
    M -- No --> N[Print no student records found]
    M -- Yes --> O[Print each student with total, percentage, and grade]
    N --> G
    O --> G

    H -- "3. Search by ID" --> P[Read target ID]
    P --> Q{ID found in list?}
    Q -- Yes --> R[Print matching student details]
    Q -- No --> S[Print student not found]
    R --> G
    S --> G

    H -- "4. Exit" --> T([Close scanner and end program])
    H -- "Invalid input" --> U[Print invalid choice]
    U --> G
```

### 🧠 Flow Explanation (Step-by-Step)

1. **Program startup**  
   `Main` creates an instance of `ResultManager`. In its constructor, `loadFromFile()` runs automatically.

2. **Data loading phase**  
   - If `data/students.txt` does not exist, the app starts with an empty in-memory list.
   - If it exists, each line is parsed and converted into a `Student` object.

3. **Menu loop**  
   The program displays a menu continuously:
   - `1` → Add Student
   - `2` → View All Results
   - `3` → Search by ID
   - `4` → Exit

4. **Add Student flow**  
   Input values are collected, then a new `Student` object is created. The student is added to the list, and the file is rewritten so data remains persistent.

5. **View Results flow**  
   If no records exist, an informative message appears. Otherwise, each student is printed with total, percentage, and grade.

6. **Search flow**  
   The user enters an ID. The system scans the list and either prints the matched student or a "not found" message.

7. **Exit flow**  
   On option `4`, resources are closed and the application terminates safely.

---

## ▶️ How to Run

### Method 1: Java IDE

1. Clone the repository.
2. Open the project in IntelliJ IDEA / Eclipse / VS Code.
3. Run `src/Main.java`.

### Method 2: Command Line

```bash
javac src/*.java
java -cp src Main
```

### Method 3: Windows Quick Run

- Double-click `run.bat`.

---

## 🛠️ Tech Stack & Concepts

- **Java** (Core language)
- **OOP** (Encapsulation and class-based design)
- **Collections Framework** (`ArrayList` for storing student records)
- **Scanner** (interactive console input)
- **File I/O** (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`)

---

## 🔮 Future Improvements

- Store and recover **individual subject marks** accurately from file
- Add input validation and error handling for non-numeric values
- Add sorting/filtering (topper list, grade-wise list)
- Migrate file storage to **MySQL** or **SQLite**
- Build a GUI version using **JavaFX**

---

## 📌 Learning Value

This project is useful for:

- Beginners practicing Java classes and objects
- Understanding menu-driven console programs
- Learning basic persistence without databases
- Building a strong foundation for larger Java applications

---

⭐ If you found this project helpful, consider starring the repository.
