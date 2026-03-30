# GitHub to Slack Commit Tracker

##  Project Overview
**Screening Assignment**: GitHub to Slack Commit Tracker  
**Deadline**: 2nd April 2026, 05:00 PM IST  

This backend service tracks when developers push code to GitHub, stores the commit history, and automatically notifies the team in Slack. It demonstrates integration between GitHub webhooks, a Spring Boot application, H2 database persistence, and Slack API messaging.

---

## ⚙️ Tech Stack
- **Language**: Java (11+)
- **Framework**: Spring Boot
- **Database**: H2 (In-Memory) with Hibernate / Spring Data JPA
- **Messaging**: Slack API

---

##  Acceptance Criteria

### 1. GitHub Integration
- Application detects when a user pushes code to a GitHub repository via webhook events.

### 2. Data Extraction
- Extracts:
  - **Author** (who pushed the code)
  - **Commits** (individual commit messages and changes)

### 3. Database Storage
- Saves extracted data into H2 using JPA/Hibernate.
- Database schema links each author to multiple commits.

### 4. Slack Notification
- After saving data, sends a summary message to Slack:
  - Author name
  - List of commit messages

---

##  How to Run

1. **Clone the repository**  
   ```bash
   git clone <repo-url>
   cd Commit-tracker
