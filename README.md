# Pet Adoption Center API

## Requirements

Building an API for a local pet adoption center. Staff can register new animals, update their details, mark them as adopted, and remove them from the database once adopted.  

---

## Entities

### Pet
| Field            | Type       | Description                          |
|-----------------|------------|--------------------------------------|
| `id`            | Long       | Auto-generated                        |
| `name`          | String     | Required, max length 50               |
| `species`       | Enum       | DOG, CAT, BIRD, RABBIT, OTHER        |
| `breed`         | String     | Optional                              |
| `age`           | Integer    | In years                              |
| `adoptionStatus`| Enum       | AVAILABLE, ADOPTED, PENDING           |
| `arrivalDate`   | LocalDate  | Date of arrival                        |
| `description`   | String     | Optional, max length 250              |

---

## Endpoints

| HTTP Method | Endpoint            | Description                     |
|------------|-------------------|---------------------------------|
| POST       | `/api/pets`        | Add a new pet for adoption      |
| GET        | `/api/pets`        | Get all pets                    |
| GET        | `/api/pets/{id}`   | Get pet by ID                   |
| PUT        | `/api/pets/{id}`   | Update pet details              |
| PATCH      | `/api/pets/{id}/adopt` | Mark pet as adopted          |
| DELETE     | `/api/pets/{id}`   | Remove pet from database        |

---

## Example Requests

### 1. Add a Pet

**POST /api/pets**

```json
{
  "name": "Bella",
  "species": "DOG",
  "breed": "Labrador Retriever",
  "age": 3,
  "adoptionStatus": "AVAILABLE",
  "arrivalDate": "2025-08-10",
  "description": "Friendly and loves kids."
}
```

### 2. Adopt a Pet
**PATCH /api/pets/5/adopt**

```json
{ 
 "id": 5, 
 "name": "Bella", 
 "species": "DOG", 
 "adoptionStatus": "ADOPTED" 
} 
```


## Output
### Created SQL Schema
<img width="2152" height="380" alt="Screenshot from 2025-08-13 22-01-50" src="https://github.com/user-attachments/assets/787bd52e-3e31-4ff2-aff5-4d6764463991" />

### All Requests

#### Get_Pets
<img width="1694" height="1532" alt="Screenshot from 2025-08-13 22-02-28" src="https://github.com/user-attachments/assets/704f405d-3ca6-4cff-96d5-685425d5d9f0" />

#### Posts_Pets
<img width="1694" height="1532" alt="Screenshot from 2025-08-13 22-03-06" src="https://github.com/user-attachments/assets/4347c8bc-482e-4f61-a019-e5031bf2cd4b" />

#### Gets_Pets_ID
<img width="1694" height="1532" alt="Screenshot from 2025-08-13 22-03-32" src="https://github.com/user-attachments/assets/4280a4c2-0310-4d85-b022-8e32cc3b1dc5" />

#### Put_Pets
<img width="1694" height="1532" alt="Screenshot from 2025-08-13 22-04-40" src="https://github.com/user-attachments/assets/6485f56f-5053-4578-9132-20de182a87b6" />

#### Patch_Pets
<img width="1694" height="1532" alt="Screenshot from 2025-08-13 22-05-22" src="https://github.com/user-attachments/assets/61873d4a-7543-47a0-81f6-017c1fa6d249" />

## Future
1. Search & Filter: Find pets by species, breed, or age
2. Pagination & Sorting: Show only a few pets at a time
3. Photo Upload: Save image URLs for pets


