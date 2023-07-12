const bankAccount = {
    accountNumber: '123456789',
    accountHolderName: 'Alice',
    balance: 1000,

    // Вариант с регулярными функциями:

    // deposit: function(amount) {
    //     amount >= 10000 ?
    //         console.log('Требуется подтверждение легальности доходов') :
    //         this.balance += amount;
    // },
    // withdraw: function(amount) {
    //     amount > 0 && amount <= this.balance ?
    //         this.balance -= amount :
    //         console.log('Некорректно введена сумма или на счету недостаточно средств');
    // },
    // checkBalance: function () {
    //     console.log(`Баланс: ${this.balance}`);
    // },

    // Вариант со стрелочными функциями:

    // deposit: (amount) => {
    //     amount >= 10000 ?
    //         console.log('Требуется подтверждение легальности доходов') :
    //         bankAccount.balance += amount;
    // },
    // withdraw: (amount) => {
    //     amount > 0 && amount <= bankAccount.balance ?
    //         bankAccount.balance -= amount :
    //         console.log('Некорректно введена сумма или на счету недостаточно средств');
    // },
    // checkBalance: () => {
    //     console.log(`Баланс: ${bankAccount.balance}`);
    // }

    // Вариант с регулярными функциями (ч.2):

    deposit(amount) {
        amount >= 10000 ?
            console.log('Требуется подтверждение легальности доходов') :
            this.balance += amount;
    },
    withdraw(amount) {
        amount > 0 && amount <= this.balance ?
            this.balance -= amount :
            console.log('Некорректно введена сумма или на счету недостаточно средств');
    },
    checkBalance() {
        console.log(`Баланс: ${this.balance}`);
    }
};

bankAccount.checkBalance();
bankAccount.deposit(1586);
bankAccount.checkBalance();
bankAccount.withdraw(258);
bankAccount.checkBalance();