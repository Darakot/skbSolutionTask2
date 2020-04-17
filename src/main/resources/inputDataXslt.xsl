<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" omit-xml-declaration="no" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/root">
        <xsl:copy>
            <xsl:apply-templates/>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="/root/body">
        <xsl:copy>
            <xsl:copy-of select="*"/>
        </xsl:copy>
    </xsl:template>

</xsl:stylesheet>
