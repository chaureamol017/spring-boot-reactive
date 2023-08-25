buildSpringBoot() {
  cd $1
  pwd
  mvn clean package spring-boot:repackage -DskipTests=true
  cd ..
}

#buildSpringBoot 'demo-producer'
#buildSpringBoot 'demo-consumer'

docker-compose up -d

