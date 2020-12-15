package ru.webanimal.test48_bottom_navigation.data.api

import ru.webanimal.test48_bottom_navigation.data.models.Movie

class MoviesHttpClient : MoviesApi {
    override suspend fun getMoviesAsync(): List<Movie> = MoviesData.data()
}

private object MoviesData {
    fun data(): List<Movie> = listOf(
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg",
            title = "Rogue City",
            overview = "Caught in the crosshairs of police corruption and Marseille’s warring gangs, a loyal cop must protect his squad by taking matters into his own hands."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg",
            title = "Hard Kill",
            overview = "The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/7D430eqZj8y3oVkLFfsWXGRcpEG.jpg",
            title = "2067",
            overview = "A lowly utility worker is called to the future by a mysterious radio signal, he must leave his dying wife to embark on a journey that will force him to face his deepest fears in an attempt to change the fabric of reality and save humankind from its greatest environmental crisis yet."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/betExZlgK0l7CZ9CsCBVcwO1OjL.jpg",
            title = "Roald Dahl's The Witches",
            overview = "In late 1967, a young orphaned boy goes to live with his loving grandma in the rural Alabama town of Demopolis. As the boy and his grandmother encounter some deceptively glamorous but thoroughly diabolical witches, she wisely whisks him away to a seaside resort. Regrettably, they arrive at precisely the same time that the world's Grand High Witch has gathered."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/elZ6JCzSEvFOq4gNjNeZsnRFsvj.jpg",
            title = "Welcome to Sudden Death",
            overview = "Jesse Freeman is a former special forces officer and explosives expert now working a regular job as a security guard in a state-of-the-art basketball arena. Trouble erupts when a tech-savvy cadre of terrorists kidnap the team's owner and Jesse's daughter during opening night. Facing a ticking clock and impossible odds, it's up to Jesse to not only save them but also a full house of fans in this highly charged action thriller."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/kiX7UYfOpYrMFSAGbI6j1pFkLzQ.jpg",
            title = "After We Collided",
            overview = "Tessa finds herself struggling with her complicated relationship with Hardin; she faces a dilemma that could change their lives forever."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/riYInlsq2kf1AWoGm80JQW5dLKp.jpg",
            title = "Enola Holmes",
            overview = "While searching for her missing mother, intrepid teen Enola Holmes uses her sleuthing skills to outsmart big brother Sherlock and help a runaway lord."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/xZNw9xxtwbEf25NYoz52KdbXHPM.jpg",
            title = "The New Mutants",
            overview = "Five young mutants, just discovering their abilities while held in a secret facility against their will, fight to escape their past sins and save themselves."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
            title = "Mulan",
            overview = "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/hddzYJtfYYeMDOQVcH58n8m1W3A.jpg",
            title = "Once Upon a Snowman",
            overview = "The previously untold origins of Olaf, the innocent and insightful, summer-loving snowman are revealed as we follow Olaf’s first steps as he comes to life and searches for his identity in the snowy mountains outside Arendelle."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/k8Q9ulyRE8fkvZMkAM9LPYMKctb.jpg",
            title = "Batman: Death in the Family",
            overview = "Tragedy strikes the Batman's life again when Robin Jason Todd tracks down his birth mother only to run afoul of the Joker. An adaptation of the 1988 comic book storyline of the same name."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/h8Rb9gBr48ODIwYUttZNYeMWeUU.jpg",
            title = "Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train",
            overview = "Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!"
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/e98dJUitAoKLwmzjQ0Yxp1VQrnU.jpg",
            title = "Come Play",
            overview = "A lonely young boy feels different from everyone else. Desperate for a friend, he seeks solace and refuge in his ever-present cell phone and tablet. When a mysterious creature uses the boy’s devices against him to break into our world, his parents must fight to save their son from the monster beyond the screen."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/AnVD7Gn14uOTQhcc5xYZGQ9DRvS.jpg",
            title = "VFW",
            overview = "A typical night for veterans at a VFW turns into an all-out battle for survival when a desperate teen runs into the bar with a bag of stolen drugs. When a gang of violent punks come looking for her, the vets use every weapon at their disposal to protect the girl and themselves from an unrelenting attack."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/qzA87Wf4jo1h8JMk9GilyIYvwsA.jpg",
            title = "Ava",
            overview = "A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/6CoRTJTmijhBLJTUNoVSUNxZMEI.jpg",
            title = "Money Plane",
            overview = "A professional thief with \$40 million in debt and his family's life on the line must commit one final heist - rob a futuristic airborne casino filled with the world's most dangerous criminals."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/lQfdytwN7eh0tXWjIiMceFdBBvD.jpg",
            title = "Over the Moon",
            overview = "A girl builds a rocket to travel to the moon in hopes of meeting the legendary Moon Goddess."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/sy6DvAu72kjoseZEjocnm2ZZ09i.jpg",
            title = "Peninsula",
            overview = "A soldier and his team battle hordes of post-apocalyptic zombies in the wastelands of the Korean Peninsula."
        ),
        Movie(
            avatarUrl = "https://image.tmdb.org/t/p/w342/6agKYU5IQFpuDyUYPu39w7UCRrJ.jpg",
            title = "Borat Subsequent Moviefilm",
            overview = "14 years after making a film about his journey across the USA, Borat risks life and limb when he returns to the United States with his young daughter, and reveals more about the culture, the COVID-19 pandemic, and the political elections."
        )
    )
}