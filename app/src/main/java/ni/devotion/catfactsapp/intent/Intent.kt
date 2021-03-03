package ni.devotion.catfactsapp.intent

sealed class Intent {
    object GetCatEvent: Intent()
    object None: Intent()
}