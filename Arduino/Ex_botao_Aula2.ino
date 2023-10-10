int led = 13;
int valor=0;
int botao=12;
int var=0;
int var2=0;
int estado=0;
  
void setup() {
  pinMode (led, OUTPUT);
  pinMode (botao, INPUT);
}

void loop() {
  var=digitalRead (botao);

  if (( var==1) && (var2 ==0))
  {
    estado=1-estado;
    delay(20);
  }
  var2=var;

  if(estado==1){
    digitalWrite(led,1);
  }
  else
    digitalWrite(led,0);
}
