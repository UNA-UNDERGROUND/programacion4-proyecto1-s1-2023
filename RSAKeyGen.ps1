# este script es un utilitario para generar llaves RSA de prueba
# para el uso de tokens bearer


param(
    [Parameter(Mandatory = $true)]
    [string]$keyName,
    [Parameter(Mandatory = $true)]
    [string]$keyPath
)

if (!(Test-Path $keyPath)) {
    New-Item -ItemType Directory -Force -Path $keyPath
}

$rsa = New-Object System.Security.Cryptography.RSACryptoServiceProvider -ArgumentList 2048

$privatePEM = $rsa.ExportRSAPrivateKeyPem()
$publicPEM = $rsa.ExportRSAPublicKeyPem()

$privatePEM | Out-File "$keyPath\$keyName.pem" -Encoding ascii
$publicPEM | Out-File "$keyPath\$keyName.pub.pem" -Encoding ascii


