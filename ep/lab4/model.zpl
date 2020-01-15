set Products := { 1 .. 7 };
set Machines := { "Grinder", "VDrill", "HDrill", "Auger", "Planer" };
set Months   := { 1 .. 6 };
set MonthsEx := { 0 .. 6 };

param revenue[Products] := <1> 10, <2> 6, <3> 8, <4> 4, <5> 11, <6> 9, <7> 3;

param process[Machines * Products] :=
           | 1   , 2   , 3   , 4   , 5   , 6   , 7    |
|"Grinder" | 0.5 , 0.7 , 0   , 0   , 0.3 , 0.2 , 0.5  |
|"VDrill"  | 0.1 , 0.2 , 0   , 0.3 , 0   , 0.6 , 0    |
|"HDrill"  | 0.2 , 0   , 0.8 , 0   , 0   , 0   , 0.6  |
|"Auger"   | 0.05, 0.03, 0   , 0.07, 0.1 , 0   , 0.08 |
|"Planer"  | 0   , 0   , 0.01, 0   , 0.05, 0   , 0.05 |;

param availability[Machines * Months] :=
           |     1,     2,     3,     4,     5,     6 |
|"Grinder" |     3,     4,     4,     4,     3,     4 |
|"VDrill"  |     2,     2,     2,     1,     1,     2 |
|"HDrill"  |     3,     1,     3,     3,     3,     2 |
|"Auger"   |     1,     1,     0,     1,     1,     1 |
|"Planer"  |     1,     1,     1,     1,     1,     0 |;

param demand[Months * Products] :=
           |    1,    2,    3,    4,    5,    6,    7 |
|        1 |  500, 1000,  300,  300,  800,  200,  100 |
|        2 |  600,  500,  200,    0,  400,  300,  150 |
|        3 |  300,  600,    0,    0,  500,  400,  100 |
|        4 |  200,  300,  400,  500,  200,    0,  100 |
|        5 |    0,  100,  500,  100, 1000,  300,    0 |
|        6 |  500,  500,  100,  300, 1100,  500,   60 |;

param hours_per_month := 2 * 8 * 24;
param storage_capacity := 100;
param storage_price := 0.5;

var production[<p, m> in Products * Months] integer >= 0 <= demand[m, p] + storage_capacity;
var sales[<p, m> in Products * Months] integer >= 0 <= demand[m, p];
var storage[<p, m> in Products * MonthsEx] integer >= 0 <= 100;

maximize profit: sum <p, m> in Products * Months : (revenue[p] * sales[p, m] - storage_price * storage[p, m]);

subto machines:
  forall <mo, ma> in Months * Machines do
    sum <p> in Products : production[p, mo] * process[ma, p] <= availability[ma, mo] * hours_per_month;

subto storage0:
  forall <p> in Products:
    storage[p, 0] == 0;

subto storage6:
  forall <p> in Products:
    storage[p, 6] == 50;

subto do_not_produce_excessive:
  forall <p, m> in Products * Months do
    production[p, m] <= sales[p, m] + storage[p, m];

subto sale:
  forall <p, m> in Products * Months do
    production[p, m] + storage[p, m - 1] == sales[p, m] + storage[p, m];
