
pipeline {
    agent any

environment {
appName = "variable"
GRADLE_HOME = tool 'Gradle'
}

    stages {
        stage("Build") {
            steps {
                script{
                bat "${GRADLE_HOME}\\gradle build"
                }
            }
        }
}
    post{
        always{
            deleteDir()
            echo "Comando always = Este mensaje siempre se ejecutara"
        }
        success{
            echo "Tarea Exitosa"
        }
        failure{
            echo "Tarea Fallida - Revisar Log"
        }
    }
}
