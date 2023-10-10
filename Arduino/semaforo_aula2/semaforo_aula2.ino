
int led_vermelho = 13; 
int led_amarelo = 12;
int led_verde = 11;

int led_vermelho1 = 2; 
int led_amarelo1 = 3;
int led_verde1 = 4;

/*int led_vermelho2 = 7; 
int led_amarelo2 = 6;
int led_verde2 = 5;*/

void setup() {
  // put your setup code here, to run once:
  pinMode(led_vermelho, OUTPUT);
  pinMode(led_amarelo, OUTPUT);
  pinMode(led_verde, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(led_vermelho, 0); //primeiro 
  digitalWrite(led_amarelo, 0); //primeiro 
  digitalWrite(led_verde, 1); //primeiro 
  digitalWrite(led_vermelho1, 1); //segundo
  digitalWrite(led_amarelo1, 0); //segundo
  digitalWrite(led_verde1, 0); //segundo
  delay(2000);

   digitalWrite(led_vermelho, 0); //primeiro
   digitalWrite(led_verde, 0); //primeiro
   digitalWrite(led_amarelo, 1); //primeiro
   digitalWrite(led_vermelho1, 1); //segundo
   digitalWrite(led_verde1, 0); //segundo
   digitalWrite(led_amarelo1, 0); //segundo
   delay(500);
   digitalWrite(led_vermelho, 1); //primeiro
   digitalWrite(led_verde, 0); //primeiro
   digitalWrite(led_amarelo, 0); //primeiro
   delay(500);

  digitalWrite(led_vermelho, 1); //primeiro
  digitalWrite(led_amarelo, 0); //primeiro
  digitalWrite(led_verde, 0); //primeiro
  digitalWrite(led_vermelho1, 0); //segundo
  digitalWrite(led_amarelo1, 0); //segundo
  digitalWrite(led_verde1, 1); //segundo
  delay(2000);

   digitalWrite(led_vermelho, 1); //primeiro
   digitalWrite(led_verde, 0); //primeiro
   digitalWrite(led_amarelo, 0); //primeiro
   digitalWrite(led_vermelho1, 0); //segundo
   digitalWrite(led_verde1, 0); //segundo
   digitalWrite(led_amarelo1, 1); //segundo
   delay(500);



}


