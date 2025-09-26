flowchart TD
    subgraph Frontend [Frontend - React + TS]
        UI[User Interface]
    end

    subgraph Backend [Backend - Spring Boot]
        Controller[Controllers]
        Service[Services]
        Repository[Repositories]
        Entity[Entities/DTOs]
    end

    DB[(PostgreSQL Database)]

    UI -->|REST API| Controller
    Controller --> Service
    Service --> Repository
    Repository --> DB
