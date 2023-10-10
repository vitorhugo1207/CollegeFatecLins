#define NOTE_B0  31
#define NOTE_C1  33
#define NOTE_CS1 35
int beep = 12;
char inputUser;

void setup() {
  pinMode(beep, OUTPUT);
  Serial.begin (9600);
}

void loop() {
  if(Serial.available()){
    inputUser = Serial.read();
    
    if(inputUser == 'B'){
      tone(12, NOTE_B0, 1000);
    }
    if(inputUser == 'C'){
      tone(12, NOTE_C1, 1000);
    }
     if(inputUser == 'D'){
      tone(12, NOTE_CS1, 5000);
  }
}
}
