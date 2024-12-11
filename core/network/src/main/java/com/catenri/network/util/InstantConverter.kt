package com.catenri.network.util

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import kotlinx.datetime.Instant
import javax.inject.Inject

class InstantConverter @Inject constructor(
    private val instantParser: InstantParser
) : TypeAdapter<Instant>() {

    override fun write(out: JsonWriter, instant: Instant?) {
        out.value(instant?.toEpochMilliseconds())
    }

    override fun read(reader: JsonReader): Instant? {
        return if (reader.peek() == JsonToken.NULL) {
            reader.nextNull()
            null
        } else {
            val dateStr: String? = reader.nextString()
            return if (dateStr.isNullOrBlank()) null
            else instantParser.stringToInstant(dateStr)
        }
    }
}