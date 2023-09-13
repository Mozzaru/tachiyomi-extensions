package eu.kanade.tachiyomi.extension.en.realmscansx

import eu.kanade.tachiyomi.multisrc.mangathemesia.MangaThemesia
import eu.kanade.tachiyomi.network.interceptor.rateLimit
import eu.kanade.tachiyomi.source.model.Page
import okhttp3.Headers
import okhttp3.OkHttpClient
import org.jsoup.nodes.Document
import java.util.concurrent.TimeUnit

class RealmScansX : MangaThemesia("Realm Scans X", "https://realmscans.to", "en", "/series") {

    override val client: OkHttpClient = super.client.newBuilder()
        .rateLimit(20, 5, TimeUnit.SECONDS)
        .build()

    override fun headersBuilder(): Headers.Builder = Headers.Builder()
        .add("Referer", baseUrl)

    override fun pageListParse(document: Document): List<Page> {
        return super.pageListParse(document)
            .distinctBy { it.imageUrl }
            .mapIndexed { i, page -> Page(i, imageUrl = page.imageUrl) }
    }
}
