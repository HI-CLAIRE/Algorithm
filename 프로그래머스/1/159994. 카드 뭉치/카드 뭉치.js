function checkCards (cards, goal) {
    const cardsFilteredByGoal = goal.filter((item, index) => cards.includes(item));
    
    const cardFilteredByIndex = cardsFilteredByGoal.filter((item, index) => item === cards[index]);
    
    if(cardFilteredByIndex.length !== cardsFilteredByGoal.length){
        return false;
    }
    
    return true;
}

function solution(cards1, cards2, goal) {    
    if(checkCards(cards1, goal) && checkCards(cards2, goal)){
        return "Yes";
    }
    
    return "No";
}