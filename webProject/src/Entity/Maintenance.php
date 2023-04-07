<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity]
class Maintenance
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $idDemande = null;

    #[ORM\Column(type: 'text')]
    #[Assert\NotBlank]
    private ?string $description = null;

    #[ORM\Column(length: 20)]
    #[Assert\Choice(choices: ['en cours', 'resolu'], message: 'Invalid status.')]
    private ?string $status = 'en cours';

    #[ORM\Column(type: 'datetime')]
    private ?\DateTime $submissionDate = null;

    #[ORM\Column(type: 'integer')]
    #[Assert\Choice(choices: [1, 2, 3, 4, 5], message: 'Invalid rating.')]
    private ?int $rating = null;

    public function getIdDemande(): ?int
    {
        return $this->idDemande;
    }

    public function setIdDemande(?int $idDemande): void
    {
        $this->idDemande = $idDemande;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(?string $description): void
    {
        $this->description = $description;
    }

    public function getStatus(): ?string
    {
        return $this->status;
    }

    public function setStatus(?string $status): void
    {
        $this->status = $status;
    }

    public function getSubmissionDate(): ?\DateTime
    {
        return $this->submissionDate;
    }

    public function setSubmissionDate(?\DateTime $submissionDate): void
    {
        $this->submissionDate = $submissionDate;
    }

    public function getRating(): ?int
    {
        return $this->rating;
    }

    public function setRating(?int $rating): void
    {
        $this->rating = $rating;
    }
    private $cin;
    public function getCin(): \User
    {
        return $this->cin;
    }
    public function setCin(\User $cin): Maintenance
    {
        $this->cin = $cin;
        return $this;
    }
}