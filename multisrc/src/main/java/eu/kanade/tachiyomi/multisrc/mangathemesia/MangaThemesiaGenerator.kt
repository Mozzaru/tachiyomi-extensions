package eu.kanade.tachiyomi.multisrc.mangathemesia

import generator.ThemeSourceData.SingleLang
import generator.ThemeSourceGenerator

// Formerly WPMangaStream & WPMangaReader -> MangaThemesia
class MangaThemesiaGenerator : ThemeSourceGenerator {

    override val themePkg = "mangathemesia"

    override val themeClass = "MangaThemesia"

    override val baseVersionCode: Int = 26

    override val sources = listOf(
        SingleLang("Asura Scans X", "https://asuracomic.net", "en", overrideVersionCode = 13),
        SingleLang("Luminous Scans", "https://lumitoon.com", "en", overrideVersionCode = 3),
        SingleLang("Rizz Comic X", "https://rizzcomic.com", "en"),
    )

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            MangaThemesiaGenerator().createAll()
        }
    }
}
