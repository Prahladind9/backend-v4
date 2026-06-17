const express = require('express');
const app = express();
const PORT = process.env.PORT || 4999;

app.use(express.json());

const DB = []

// GET POST PATCH PUT DELETE
app.get('/get', (req, res) => {
    console.log('You have reached the home route: GET')
    res.status(200)
        .send('Hello');
})

app.post('/api/info', (req, res) => {
    const { information } = req.body
    console.log('The posted message is: ', information)
    DB.push(information)
    console.log('The posted messages are: ', DB)
    res.status(201).json({"yourMessage": information})
})

app.delete('/delete', (req, res) => {
    console.log('You have reached the home route: DELETE')
    console.log('What do you want to delete?')
    res.sendStatus(200)
})

app.listen(PORT, () => console.log(`Server started on port ${PORT}`));

console.log('Hello world', 4*6)

