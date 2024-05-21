#!groovy

pipeline {
    agent any

    parameters {
        choice(name: 'browser', choices: ['CHROME', 'FIREFOX'], description: 'Choose a browser to run tests on')
        choice(name: 'suite', choices: ['behavioral', 'creational', 'structural'], description: 'Choose tests to run')
        booleanParam(name: 'headless', defaultValue: false, description: 'Run tests in headless mode')
    }

    stages {
        stage("Checkout the project") {
            steps {
                git branch: 'master', url: 'https://github.com/BogdanShvetss/Design_Patterns_Web_Automation.git'
            }
        }

        stage("Running tests") {
            steps {
                bat "mvn clean test -Dmaven.test.failure.ignore=true -Dbrowser=${params.browser} -Dheadless=${params.headless} -DsuiteXmlFiles=\"src/test/resources/${params.suite}.xml\""
            }
        }
    }

    post {
        always {
            script {
               allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}