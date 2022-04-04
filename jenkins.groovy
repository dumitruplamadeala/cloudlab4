#!Groovy
pipeline {
    agent any
    stages {
        stage("Build jar") {
            steps {
                script {
                    sh "cd /c/ijProjects/SB-using-JPA\n " +
                            "mvn clean compile install\n"
                }
            }
        }
        stage("Build&Tag&Push Container") {
            steps {
                script {
                    sh "cd /c/ijProjects/SB-using-JPA\n " +
                            '"C:\\Users\\dplamadeala\\AppData\\Local\\Programs\\Rancher Desktop\\resources\\resources\\win32\\bin\\docker.exe"' +
                            " build -t spring-boot-app . -t localhost:5000/spring-boot-app\n" +
                            '"C:\\Users\\dplamadeala\\AppData\\Local\\Programs\\Rancher Desktop\\resources\\resources\\win32\\bin\\docker.exe"' +
                            " push localhost:5000/spring-boot-app\n"
                }
            }
        }
    }
}
