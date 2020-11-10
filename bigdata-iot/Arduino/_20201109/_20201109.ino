void setup() {
  Serial.begin(9600);
}

void loop() {
  Serial.println("READY");
  if(Serial.available() > 0){
    char cmd = "";
    cmd = Serial.read();
    Serial.println(cmd);
    if(cmd == "s"){
      Serial.println("SENSEOR Start!");
    } else if(cmd == "t"){
      Serial.println("SENSEOR STOP!");
    }
  }
  delay(2000);
}
