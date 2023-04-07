<?php

namespace App\Entity;
use App\Repository\AbonnementRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;


#[ORM\Entity(repositoryClass: AbonnementRepository::class)]
class Abonnement
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $idAb = null;

    #[ORM\Column(length: 30)]
    private ?string $typeAb = null;

    #[ORM\Column(type: 'datetime')]
    private ?\DateTime $dateDebut = null;

    #[ORM\Column(type: 'datetime')]
    #[Assert\GreaterThan(propertyPath: 'dateDebut')]
    private ?\DateTime $dateFin = null;

    #[ORM\Column(type: 'float')]
    #[Assert\NotBlank(message: 'price non valid')]
    private ?float $prixAb = null;

    #[ORM\Column(type: 'integer')]
    #[ORM\ManyToOne(inversedBy: 'Offre')]
    #[Assert\NotNull]
    #[Assert\Entity(
        entityClass: Offre::class,
        message: 'Invalid Offre'
    )]
    private ?int $idOffre;

    public function getIdAb(): ?int
    {
        return $this->idAb;
    }

    public function setIdAb(?int $idAb): void
    {
        $this->idAb = $idAb;
    }

    public function getTypeAb(): ?string
    {
        return $this->typeAb;
    }

    public function setTypeAb(?string $typeAb): void
    {
        if (!in_array($typeAb, ['Standard', 'Premium', 'Premium+'])) {
            throw new \InvalidArgumentException('Invalid subscription type.');
        }
        $this->typeAb = $typeAb;
    }

    public function getDateDebut(): ?\DateTime
    {
        return $this->dateDebut;
    }

    public function setDateDebut(?\DateTime $dateDebut): void
    {
        $this->dateDebut = $dateDebut;
    }

    public function getDateFin(): ?\DateTime
    {
        return $this->dateFin;
    }

    public function setDateFin(?\DateTime $dateFin): void
    {
        $this->dateFin = $dateFin;
    }

    public function getPrixAb(): ?float
    {
        return $this->prixAb;
    }

    public function setPrixAb(?float $prixAb): void
    {
        if ($prixAb !== null && !is_float($prixAb)) {
            throw new \InvalidArgumentException('Price must be a float.');
        }
        $this->prixAb = $prixAb;
    }

    public function getIdOffre(): ?int
    {
        return $this->idOffre;
    }

    public function setIdOffre(?int $idOffre): void
    {
        $this->idOffre = $idOffre;
    }

}
