const int tempPin = A0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  char cmd = "";
  Serial.println("READY");
  int flag = 0;

  if(Serial.available() > 0){
    cmd = Serial.read();
    cmd = cmd.substring(7, cmd.length()); //:G11A9\n 제거 
    Serial.println(cmd);

    if(cmd == 's'){
      Serial.println("SENSEOR Start!");
      flag = 1;
      // flag  설정 여기부터 다시 짜숄!


      int data = analogRead(tempPin);
      float temp = ((5.0 * data) / 1024.0) * 100;
      Serial.println(temp);
    } else if(cmd == 't'){
      Serial.println("SENSEOR STOP!");
    }
  }
  delay(2000);
}
