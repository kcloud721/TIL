void setup() {
  Serial.begin(9600);
}
void loop() {
  String cmd="";
  if(Serial.available()){
    cmd = Serial.readString();
    cmd = cmd.substring(7,cmd.length()); //:G11A9\n제거
    Serial.println(cmd);
    if(cmd.equals("start")){
      Serial.println("Sensor Start!");
    }else if(cmd.equals("stop")){
      Serial.println("Sensor Stop!");
    }
  }
  delay(200);
}