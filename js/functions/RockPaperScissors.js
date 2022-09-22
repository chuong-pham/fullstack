const getUserChoice = userInput => {
    userInput = userInput.toLowerCase();
    if(userInput === 'rock' || userInput === 'paper' || userInput === 'scissors')
        return userInput;
    else
        console.log ("Error!");
};

const getComputerChoice = () => {
    const computerChoice = Math.floor(Math.random()*3);
    switch(computerChoice) {
        case 0: return 'rock';
        case 1: return 'paper';
        case 2: return 'scissors';
    }
};

const determineWinner = (userChoice, computerChoice) => {
    if(userChoice === computerChoice) {
        return "The game was a tie";
    }

    if(userChoice === 'rock') {
        if(computerChoice === 'paper')
            return 'Computer won';
        else
            return 'User won';
    }

    if (userChoice === 'paper') {
      if (computerChoice === 'scissors') 
        return 'Computer won';
      else 
      return 'User won';
    }

    if(userChoice === 'scissors') {
        if (computerChoice === 'rock') 
            return 'Computer won';
        else 
        return 'User won';
    }
};


const playGame = function () {
  const userChoice = getUserChoice("paper");
  const computerChoice = getComputerChoice();

  console.log(`User: ${userChoice}, Computer: ${computerChoice}`);
  const result = determineWinner(userChoice, computerChoice);
  console.log(result);
};

playGame();


