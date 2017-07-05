package com.netflix.atlas.proxy.script

import com.netflix.atlas.proxy.Tag

class Timer(q: String): TimeSeriesExpr(q) {
    constructor(name: String, tags: Collection<Tag>): this(TimeSeriesExpr.build(name, tags))

    fun distAvg(): TimeSeriesExpr {
        return Timer("$query,:dist-avg")
    }

    fun distMax(): TimeSeriesExpr {
        return Timer("$query,:dist-max")
    }

    fun latency(): TimeSeriesExpr {
        return distAvg()
    }

    fun throughput(): TimeSeriesExpr {
        return Timer("$query,statistic,count,:eq,:and")
    }
}