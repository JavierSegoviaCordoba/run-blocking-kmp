plugins {
    id("io.codearte.nexus-staging")
}

nexusStaging {
    username = System.getenv("ossUser")
    password = System.getenv("ossToken")
    stagingProfileId = System.getenv("ossStagingProfileId")
}
