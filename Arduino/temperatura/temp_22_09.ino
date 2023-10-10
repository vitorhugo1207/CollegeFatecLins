float Sensor_temp = A0;
float valor = 0;
float millivolts = 0;
float temperatura = 0;

void setup() {
  pinMode(Sensor_temp, INPUT);
  Serial.begin(9600);
}

void loop() {
  int valor = analogRead(Sensor_temp);
  millivolts = (valor * 5000) / 1024;
  temperatura = millivolts / 10;
  Serial.println(temperatura);
}
