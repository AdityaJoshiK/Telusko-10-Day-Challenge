// import logo from './logo.svg';
// import './App.css';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [questions, setQuestions] = useState([]);
  const [score, setScore] = useState(0);
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [selectedOption, setSelectedOption] = useState('');
  const [adminMode, setAdminMode] = useState(false);
  const [newQuestion, setNewQuestion] = useState({
    question: '',
    option1: '',
    option2: '',
    option3: '',
    option4: '',
    technology: '',
  });

  useEffect(() => {
    fetchQuestions();
  }, []);

  const fetchQuestions = async () => {
    try {
      const response = await axios.get('http://localhost:8080/All');
      setQuestions(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleOptionSelect = (option) => {
    setSelectedOption(option);
  };

  const submitAnswer = async () => {
    const currentAnswer = selectedOption;
    const question = questions[currentQuestion];
    const response = await axios.put(`/api/questions/${question.id}/verify`, currentAnswer);

    if (response.data) {
      setScore(score + 1);
    }

    setSelectedOption('');
    setCurrentQuestion(currentQuestion + 1);
  };

  const handleAdminModeToggle = () => {
    setAdminMode(!adminMode);
  };

  const handleInputChange = (e) => {
    setNewQuestion({ ...newQuestion, [e.target.name]: e.target.value });
  };

  const handleAddQuestion = async (e) => {
    e.preventDefault();
    try {console.log(newQuestion)
      await axios.post('http://localhost:8080/AddQuestion', newQuestion);
      setNewQuestion({
        question: '',
        option1: '',
        option2: '',
        option3: '',
        option4: '',
        technology: '',
      });
      alert('Question added successfully!');
    } catch (error) {
      console.log(error);
      alert('Failed to add the question.');
    }
  };

  return (
    <div className="App">
      <h1>Quiz App</h1>

      {adminMode ? (
        <div>
          <h2>Admin Mode</h2>
          <form onSubmit={handleAddQuestion}>
            <label>
              Question:
              <input type="text" name="question" value={newQuestion.question} onChange={handleInputChange} />
            </label>
            <br />
            <label>
              Option 1:
              <input type="text" name="option1" value={newQuestion.option1} onChange={handleInputChange} />
            </label>
            <br />
            <label>
              Option 2:
              <input type="text" name="option2" value={newQuestion.option2} onChange={handleInputChange} />
            </label>
            <br />
            <label>
              Option 3:
              <input type="text" name="option3" value={newQuestion.option3} onChange={handleInputChange} />
            </label>
            <br />
            <label>
              Option 4:
              <input type="text" name="option4" value={newQuestion.option4} onChange={handleInputChange} />
            </label>
            <br />
            <label>
              Technology:
              <input type="text" name="technology" value={newQuestion.technology} onChange={handleInputChange} />
            </label>
            <br />
            <button type="submit">Add Question</button>
          </form>
          <br/>
          <button onClick={handleAdminModeToggle}>Switch to User Mode</button>
        </div>
      ) : (
        <div>
          <h2>User Mode</h2>
          {currentQuestion < questions.length ? (
            <div>
              <h3>Question {currentQuestion + 1}</h3>
              <h4>{questions[currentQuestion].question}</h4>
              {Object.values(questions[currentQuestion])
                .slice(1, -1)
                .map((option, index) => (
                  <div key={index}>
                    <input
                      type="radio"
                      id={option}
                      name="options"
                      value={option}
                      checked={selectedOption === option}
                      onChange={() => handleOptionSelect(option)}
                    />
                    <label htmlFor={option}>{option}</label>
                  </div>
                ))}
              <br />
              <button onClick={submitAnswer}>Submit Answer</button>
            </div>
          ) : (
            <div>
              <h3>Quiz Completed!</h3>
              <h4>Your Score: {score}</h4>
            </div>
          )}
          <br />
          <button onClick={handleAdminModeToggle}>Switch to Admin Mode</button>
        </div>
      )}
      <br />
      <div>
        <h3>Score: {score}</h3>
      </div>
    </div>
  );
}

export default App;


