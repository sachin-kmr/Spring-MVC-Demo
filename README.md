# API Documentation

## <summary> View employees </summary><p>

Use to view list of all employees.

**URL** : `http://wynk.sachin-kumar.com/SpringTask/view`

**Method** : `GET`

### Success Response

**Code** : `200 Ok`

**Content example**

```json
{
      "id": "c0832ffe-8cc8-463d-adfc-da167899c0ad",
      "name": "Sachin Kumar",
      "department": "Wynk",
      "designation": "SDE"
}
```
</p>

<br/>







## <summary> Add employee </summary><p>

Use to add a employee to DB.

**URL** : `http://wynk.sachin-kumar.com/SpringTask/add`

**Method** : `POST`

**Data constraints**

```json
{
    "name": "[valid name]",
    "department": "[valid department]",
    "designation": "[valid designation]"
}
```

**Data example**

```json
{
    "name": "Sachin Kumar",
    "department": "Wynk",
    "designation": "SDE"
}
```

### Success Response

**Code** : `201 Created`

**Response example**

```json
{
    "message": "Employee added successfully!"
}
```
</p>

<br/>









## <summary> Update employee </summary><p>

Use to update a employee in DB.

**URL** : `http://wynk.sachin-kumar.com/SpringTask/update/{id}`

**Method** : `PUT`

**Data constraints**

```json
{
    "id": "[valid id]",
    "name": "[valid name]",
    "department": "[valid department]",
    "designation": "[valid designation]"
}
```

**Data example**

```json
{
    "id": "c0832ffe-8cc8-463d-adfc-da167899c0ad",
    "name": "Sachin Kumar",
    "department": "Wynk",
    "designation": "SDE"
}
```

### Success Response

**Code** : `200 Ok`

**Response example**

```json
{
    "message": "Employee updated successfully!"
}
```
</p>

<br/>





## <summary> Delete employee </summary><p>

Use to delete a employee from DB.

**URL** : `http://wynk.sachin-kumar.com/SpringTask/delete/{id}`

**Method** : `DELETE`

### Success Response

**Code** : `200 Ok`

**Response example**

```json
{
    "message": "Employee deleted successfully!"
}
```
</p>
