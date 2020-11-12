void setup() {
  Serial.begin(9600);
}

void loop() {
  char cmd = "";
  Serial.println("READY");
  if(Serial.available() > 0){
    cmd = Serial.read();
    cmd = cmd.substring(7, cmd.length()); //:G11A9\n 제거 
    Serial.println(cmd);
    if(cmd == 's'){
      Serial.println("SENSEOR Start!");
    } else if(cmd == 't'){
      Serial.println("SENSEOR STOP!");
    }
  }
  delay(2000);
}
