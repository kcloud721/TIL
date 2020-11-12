const int ledPin = A2;

void setup() {
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
}

void loop() { 
  String cmd = Serial.readString();
  if(cmd.trim() == "s"){
    digitalWrite(ledPin,HIGH);
  } else if(cmd.trim() == "t"){
    digitalWrite(ledPin,LOW);
  }
  
}
